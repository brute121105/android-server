package android.server.dao;

import java.io.Serializable;
import java.util.List;

import android.server.model.PhoneTest;
import android.server.persistence.BaseDao;




public interface PhoneMapper extends BaseDao<PhoneTest, Serializable>{
	
	List<PhoneTest> findByText(PhoneTest pt);
	
	void saveReq(PhoneTest pt);

}
