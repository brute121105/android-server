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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import android.server.dao.PhoneMapper;
import android.server.model.PhoneTest;





@RestController
public class AndroidServerHttpTest {
	final Log log=LogFactory.getLog(AndroidServerHttpTest.class);
	
	
	@Autowired
	PhoneMapper dao;

	@RequestMapping(value = "/testDB", method = RequestMethod.GET)
	public Object t2() {
		log.info("test--weixin--gongzonghao----");
		List<PhoneTest> pt = dao.findAll();
		
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}


}
