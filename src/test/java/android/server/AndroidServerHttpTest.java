package android.server;


import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;





public class AndroidServerHttpTest {
	 String HOST = "127.0.0.1:8056";
	//String HOST = "120.78.134.230:443";
	@Test
	public void test1() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.postForEntity("http://" + HOST + "/testWeixin", null,String.class);
		System.out.println(res.getBody() );
	}
	
	@Test
	public void testDb() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> resp = restTemplate.getForEntity("http://" + HOST + "/testDB",Object.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void testDBLike() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("http://" + HOST + "/testDBQC",null);
	}
	
	
}
