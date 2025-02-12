package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.model.MVCDTO;
import jspmvc.util.ConnectionUtil;

public class MVCUpdateDAO extends MVCAbstractDAO {
	
	@Override
	public int update(MVCDTO dto) {
		
		String sql = " update jspmvc set title=?, content=? where sid=? ";
		
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getSid());
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				connUtil.closeConnection(conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	} // delete
	
} // class

























