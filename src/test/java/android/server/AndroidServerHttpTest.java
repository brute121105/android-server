package android.server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;





public class AndroidServerHttpTest {
	//String HOST = "127.0.0.1:8056";
	String HOST = "120.78.134.230";
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
	public void testDb1() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/testDB",Object.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void testDBLike() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/test?data=dsf好的",String.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void save() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/save?data=帮发人找车，浦北回北通，立即走，3个大人2个孩子，联系电话18176827020",String.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void findAll() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/findAll",String.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void map() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("action", "reset");
		//map.put("action", "add");
		map.put("ee", "serv");
		ResponseEntity<Map> resp = restTemplate.postForEntity("http://" + HOST + "/androidServer/map", map,Map.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	@Test
	public void status() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/status?status=1",String.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void status1() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://" + HOST + "/androidServer/status",String.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void getValidCode(){
		   RestTemplate restTemplate = new RestTemplate();
		   String url = "http://"+HOST+"/androidServer/getValidCode";
		   Object res = restTemplate.getForObject(url,String.class);
		   System.out.println("res-->"+JSON.toJSONString(res));
		}
	
	@Test
	public void sendValidCode(){
		   RestTemplate restTemplate = new RestTemplate();
		   String url = "http://"+HOST+"/androidServer/sendValidCode?phone=136515898445&code=1211";
		   Object res = restTemplate.getForObject(url,String.class);
		   System.out.println("res-->"+JSON.toJSONString(res));
		}
	@Test
	public void testAndroid() {
		 List<String[]> devices = new ArrayList<String[]>();
	      devices.add(new String[]{"SAMSUNG","GT-S6812C","smartisan/msm"+createNum(4)+"_32/msm"+createNum(4)+"_32:4.4.4/KTU84P:user/dev-keys"});
	      String[] device =  devices.get((int)(Math.random() * devices.size()));
	      System.out.println(JSON.toJSONString(device));
	}
	 private static String createNum(int num){
	        String str = "";
	        for(int i=0;i<num;i++){
	            str = str+createRandom123();
	        }
	        return str;
	    }
	 private  static String createRandom123() {
	        String chars = "0123456789";
	        String str = chars.charAt((int)(Math.random() * 10))+"";
	        return str;
	    }
	
	
}
