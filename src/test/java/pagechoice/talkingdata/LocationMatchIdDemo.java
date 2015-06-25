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
 * 地理位置批量上传接口测试demo
 * @author xiaolong
 *
 */
public class LocationMatchIdDemo {
	@Test
	public void locMatchTest() {
		CloseableHttpClient client = Util.getHttpClient();
		HttpPost post = new HttpPost(
				"http://api.debug.talkingdata.com/common/locupload");
		File file = new File("C:\\Users\\hepeng.yang\\Desktop\\talkingdata\\location.gz");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		// 上传的数据文件(必须是gz格式)
		builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "test");
		//你的token
		builder.addTextBody("token"," oOKowNOew6GRPA");
		//你的appkey
		builder.addTextBody("appkey","557f7a768bda20a5270f883c");
		// 回调接口url，任务完成通知的url地址；
		builder.addTextBody("callBackUrl", "http://api.debug.talkingdata.com/common/download");
		//1 – 区域范围 2 – 地址围栏（暂不支持）
		builder.addTextBody("type", "1");
		//1-上传文件内容为经纬度（格式为：维度,经度），每行一条记录 2-	上传文件内容为地理位置
		builder.addTextBody("contentType", "2");
		//出现的天数，默认为1
		builder.addTextBody("frequency", "1");
		// 匹配的开始日期
		builder.addTextBody("startDay", "2015-05-16");
		// 匹配的结束日期
		builder.addTextBody("endDay", "2015-05-25");
		// 匹配范围（单位：米）
		builder.addTextBody("range", "1000");
		// 上传文件数据加密方式(可选)
		// builder.addTextBody("inputEncryptType", "xxxx");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 返回的文件类型为imei和tdid，多个用","隔开
		builder.addTextBody("outputIdType", "5");
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
	
}
