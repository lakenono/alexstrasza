package pagechoice.talkingdata;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class APPdauquery {
	@Test
	public void appDauqueryTest() {
		
		CloseableHttpClient client = Util.getHttpClient();
		HttpPost post = new HttpPost(
//				"https://api.talkingdata.com/dmp/batch/dauquery");
				"https://api.talkingdata.com/dmp/batch/mauquery");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		//你的token
		builder.addTextBody("token"," oOKowNOew6GRPA");
		//你的appkey
		builder.addTextBody("appkey","557f7a768bda20a5270f883c");
		//app name
		builder.addTextBody("app", "QQ");
		// 平台安卓
		builder.addTextBody("platform", "2");
		builder.addTextBody("data", "2015-06");
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
