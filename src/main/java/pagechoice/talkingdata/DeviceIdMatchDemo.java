package pagechoice.talkingdata;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/**
 * 设备ID数据上传接口测试demo
 * @author xiaolong
 *
 */
public class DeviceIdMatchDemo {
	/**
	 * 请求类型type为1参考这个方法
	 */
	@Test
	public void idMatchTest() {
		CloseableHttpClient client = Util.getHttpClient();
		HttpPost post = new HttpPost(
				"http://api.debug.talkingdata.com/common/idupload");
		File file = new File("C:\\Users\\hepeng.yang\\Desktop\\talkingdata\\mac.gz");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// 上传的数据文件(必须是gz格式)
		builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "test");
		builder.addTextBody("type", "6");
		// 你的token
		builder.addTextBody("token", "oOKowNOew6GRPA");
		// 你的appkey
		builder.addTextBody("appkey", "557f7a768bda20a5270f883c");
		// 回调接口url，任务完成通知的url地址；
		builder.addTextBody("callBackUrl", "http://api.debug.talkingdata.com/common/download");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 下面上传文件数据的类型为imei
		builder.addTextBody("inputIdType", "1");
		// 上传文件数据加密方式(可选)
		// builder.addTextBody("inputEncryptType", "xxxx");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 返回的文件类型为imei和tdid，多个用","隔开
		builder.addTextBody("outputIdType", "7");
		// 返回文件数据加密方式(可选)
		// builder.addTextBody("outputEncryptType", "xxxx");
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = client.execute(post);
			String content = EntityUtils.toString(response.getEntity());
			System.out.println(content);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 请求类型type为2参考这个方法
	 */
	@Test
	public void tagQueryTest() {
		CloseableHttpClient client = Util.getHttpClient();
		HttpPost post = new HttpPost(
				"http://api.debug.talkingdata.com/common/idupload");
		File file = new File("C:\\Users\\hepeng.yang\\Desktop\\talkingdata\\mac.gz");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// 上传的数据文件(必须是gz格式)
		builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "test");
		builder.addTextBody("type", "2");
		// 你的token
		builder.addTextBody("token", "oOKowNOew6GRPA");
		// 你的appkey
		builder.addTextBody("appkey", "557f7a768bda20a5270f883c");
		// 回调接口url，任务完成通知的url地址；
		builder.addTextBody("callBackUrl", "http://api.debug.talkingdata.com/common/download");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 下面上传文件数据的类型为imei
		builder.addTextBody("inputIdType", "3");
		// 上传文件数据加密方式(可选)
		// builder.addTextBody("inputEncryptType", "xxxx");
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = client.execute(post);
			String content = EntityUtils.toString(response.getEntity());
			System.out.println(content);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 请求类型type为4参考这个方法
	 */
	@Test
	public void matchLoctionTest() {
		CloseableHttpClient client = Util.getHttpClient();
		HttpPost post = new HttpPost(
				"http://api.debug.talkingdata.com/common/idupload");
		File file = new File("C:\\Users\\hepeng.yang\\Desktop\\talkingdata\\mac.gz");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// 上传的数据文件(必须是gz格式)
		builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "test");
		builder.addTextBody("type", "4");
		// 你的token
		builder.addTextBody("token", "oOKowNOew6GRPA");
		// 你的appkey
		builder.addTextBody("appkey", "557f7a768bda20a5270f883c");
		// 回调接口url，任务完成通知的url地址；
		builder.addTextBody("callBackUrl", "http://api.debug.talkingdata.com/common/download");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 下面上传文件数据的类型为imei
		builder.addTextBody("inputIdType", "3");
		// 上传文件数据加密方式(可选)
		// builder.addTextBody("inputEncryptType", "xxxx");
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = client.execute(post);
			String content = EntityUtils.toString(response.getEntity());
			System.out.println(content);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
