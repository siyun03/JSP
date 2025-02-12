package jspmvc.service.impl;

import jspmvc.dao.impl.MVCUpdateDAO;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCAbstractService;

public class MVCUpdateService extends MVCAbstractService {

	@Override
	public int update(MVCDTO dto) {
		return new MVCUpdateDAO().update(dto);
	}

}
