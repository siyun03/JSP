package jspmvc.service.impl;

import java.util.List;

import jspmvc.dao.impl.MVCSelectDAO;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCAbstractService;

public class MVCSelectService extends MVCAbstractService{

	@Override
	public List<MVCDTO> select() {
		return new MVCSelectDAO().select();
	}
	
}
