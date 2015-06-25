package pagechoice.talkingdata;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/**
 * 标签设备筛选接口测试demo
 * @author xiaolong
 *
 */
public class TagMatchIdDemo {
	@Test
	public void tagMatchIdTest() {
		CloseableHttpClient client = Util.getHttpClient();
		RequestBuilder requestBuilder = null;
		try {
			requestBuilder = RequestBuilder.post().setUri(
					new URI("http://api.debug.talkingdata.com/common/querybytag"));
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 你的token
		requestBuilder.addParameter("token", "oOKowNOew6GRPA");
		// 你的appkey
		requestBuilder.addParameter("appkey", "557f7a768bda20a5270f883c");
		//标签ID列表，多个标签用”,”分隔
		// 必须把需要的标签需求提交给TD,TD来配置对应标签获取权限
		requestBuilder.addParameter("tags", "02010302,02010201,02011602");
		//筛选时间，单位为月，最近多长时间活跃的设备，最长不超过6个月，最短为1个月，不给值的话默认1个月
		requestBuilder.addParameter("time", "1");
		// 回调接口url，任务完成通知的url地址；
		requestBuilder.addParameter("callBackUrl", "http://api.debug.talkingdata.com/common/download");
		// 1 – imei, 2-androidid, 3,mac,4-idfa, 5-tdid
		// 返回的文件类型为imei和tdid，多个用","隔开
		requestBuilder.addParameter("outputIdType", "5");
		// 返回文件数据加密方式(可选)
		// requestBuilder.addParameter("outputEncryptType", "xxxx");
		HttpUriRequest request = requestBuilder.build();
		try {
			HttpResponse response = client.execute(request);
			String content = EntityUtils.toString(response.getEntity());
			System.out.println(content);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
