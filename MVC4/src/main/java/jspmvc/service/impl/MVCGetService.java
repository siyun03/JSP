package jspmvc.service.impl;

import jspmvc.dao.impl.MVCGetDAO;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCAbstractService;

public class MVCGetService extends MVCAbstractService{
	
	 @Override
	public MVCDTO get(int sid) {
		return new MVCGetDAO().get(sid);
	}

}
