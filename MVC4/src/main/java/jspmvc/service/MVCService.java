package jspmvc.service;

import java.util.List;

import jspmvc.model.MVCDTO;

public interface MVCService {
	
	public abstract int insert(MVCDTO dto);
	
	public abstract List<MVCDTO> select();
	
	public abstract MVCDTO get(int sid);
	
	public abstract void delete(int sid);
	
	public abstract int update(MVCDTO dto);

}
