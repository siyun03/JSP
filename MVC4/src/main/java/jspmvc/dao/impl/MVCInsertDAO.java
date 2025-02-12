package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.model.MVCDTO;
import jspmvc.util.ConnectionUtil;

public class MVCInsertDAO extends MVCAbstractDAO{
	
	@Override
	public int insert(MVCDTO dto) {
		
		String sql = "insert into jspmvc values(jspmvc_seq.nextval, ?, ?)";
		
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connUtil.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				connUtil.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public MVCDTO get(int sid) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
