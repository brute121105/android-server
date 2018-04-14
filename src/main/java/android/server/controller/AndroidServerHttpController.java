package android.server.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import android.server.conf.CacheConf;
import android.server.conf.ValicodeCache;
import android.server.dao.PhoneMapper;
import android.server.model.PhoneTest;
import android.server.service.DataService;





@RestController
@RequestMapping(value="/androidServer")
public class AndroidServerHttpController {
	final Log log=LogFactory.getLog(AndroidServerHttpController.class);
	
	
	@Autowired
	PhoneMapper dao;
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/getValidCode", method = RequestMethod.GET)
	public String getValidCode() {
		String phone = ValicodeCache.phone;
		String code = ValicodeCache.valicode;
		log.info("getValidCodec----"+code);
		return phone+","+code;
	}
	
	@RequestMapping(value = "/sendValidCode", method = RequestMethod.GET)
	public String sendValidCode(String phone,String code) {
		if(!StringUtils.isEmpty(phone)) {
			ValicodeCache.phone = phone;
			log.info("sendValidCode----phone:"+phone);
		}
		if(!StringUtils.isEmpty(code)) {
			ValicodeCache.valicode = code;
			log.info("sendValidCode----code:"+code);
		}
		return "OK";
	}
	

	@RequestMapping(value = "/testDB", method = RequestMethod.GET)
	public Object t2() {
		log.info("test--AndroidServerHttpController--AndroidServerHttpController----");
		List<PhoneTest> pt = dao.findAll();
		
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String t2(String data) {
		log.info("data-->"+data);
		return "OK";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(String data) {
		log.info("save data-->"+data);
		dataService.save(data);
		return "OK";
	}
	

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll() {
		List<PhoneTest> pts = dataService.findAll();
		log.info("fillAll--->"+JSON.toJSONString(pts));
		return JSON.toJSONString(pts);
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	public Map<String,String> save(@RequestBody Map<String,String> reqMap) {
		log.info("reqMap-->"+reqMap);
		Map<String,String> resMap = CacheConf.getOrUpdateMap(reqMap);
		log.info("resMap-->"+resMap);
		return resMap;
	}
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String status(String status) {
		log.info("status-->"+status);
		if(status==null||"null".equals(status)) {
			return CacheConf.status;
		}else {
			CacheConf.status = status;
			return CacheConf.status;
		}
	}


}
