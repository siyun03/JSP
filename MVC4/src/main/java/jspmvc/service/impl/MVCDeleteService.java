package jspmvc.service.impl;

import jspmvc.dao.impl.MVCDeleteDAO;
import jspmvc.service.MVCAbstractService;

public class MVCDeleteService extends MVCAbstractService {

	@Override
	public void delete(int sid) {
		new MVCDeleteDAO().delete(sid);
	}

}
