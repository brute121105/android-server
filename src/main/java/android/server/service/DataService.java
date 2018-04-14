package android.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import android.server.dao.PhoneMapper;
import android.server.model.PhoneTest;
import android.server.util.MsgUtil;




@Service
public class DataService {
	
	private static Logger log = LoggerFactory.getLogger(DataService.class);
	
	@Autowired
	PhoneMapper dao;
	
	public void save(String data) {
		String text = MsgUtil.insertDomain(data);
		PhoneTest pt = new PhoneTest();
		pt.setText(text);
		pt.setCreate_time(new Date());
		dao.save(pt);
	}
	
	public List<PhoneTest> findAll() {
	   List<PhoneTest> pts = dao.findAll();
	   return pts;
	}

}