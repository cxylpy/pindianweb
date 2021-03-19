package test;


import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.pindian.lonphy.dao.UserDao;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.exception.RegisterException;
import com.pindian.lonphy.service.UserService;

public class DaoTest {
//	@Test
	public void testSave() {
		UserDao uDao = new UserDao();
		uDao.addCost("297e08164f81f3e0014f822d89620000", 0.1f);
	}
}
