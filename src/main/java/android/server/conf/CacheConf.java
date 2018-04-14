package android.server.conf;

import java.util.HashMap;
import java.util.Map;

public class CacheConf {
	
	public static String status;
	
	public static Map<String,String> map = new HashMap<String,String>();
	
	public static Map<String,String> getOrUpdateMap(Map<String,String> reqMap) {
		if(reqMap==null||reqMap.isEmpty()) return map;
		if("add".equals(reqMap.get("action"))) {
			for(String key:reqMap.keySet()) {
				map.put(key, reqMap.get(key));
			}
		}else if("reset".equals(reqMap.get("action"))) {
			map = new HashMap<String,String>();
		}
		return map;
	}

}
