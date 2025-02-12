package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.util.ConnectionUtil;

public class MVCDeleteDAO extends MVCAbstractDAO {
	
	@Override
	public void delete(int sid) {
		
		String sql = " delete jspmvc where sid=" + sid;
		
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				connUtil.closeConnection(conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	} // delete
	
} // class

























