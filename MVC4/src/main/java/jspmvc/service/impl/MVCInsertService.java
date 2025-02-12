package jspmvc.service.impl;

import java.util.List;

import jspmvc.dao.impl.MVCInsertDAO;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCAbstractService;
import jspmvc.service.MVCService;

public class MVCInsertService extends MVCAbstractService{

	@Override
	public int insert(MVCDTO dto) {
		return new MVCInsertDAO().insert(dto);
	}

}
