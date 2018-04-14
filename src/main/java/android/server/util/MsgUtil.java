package android.server.util;

import java.util.ArrayList;
import java.util.List;

import android.server.conf.DomainConf;


public class MsgUtil {
	
	public static String insertDomain(String text) {
		if(text.contains("[")&&text.contains("]")) return text;
		if(text.contains("【")&&text.contains("】")) return text;
		String result = "";
		String text1 = text.trim();
		List<String> domains = DomainConf.getDomain();
		List<String> dsg = new ArrayList<String>();
		for(String domain:domains){
			if(text1.indexOf(domain)>-1) {
				dsg.add(domain);
			}
		}
		if(dsg.size()==2) {
			if(text1.indexOf(dsg.get(0))<text1.indexOf(dsg.get(1))){
				result = "【"+dsg.get(0)+"→"+dsg.get(1)+"】";
			}else {
				result = "【"+dsg.get(1)+"→"+dsg.get(0)+"】";
			}
		}
		return result+text;
	}

}
