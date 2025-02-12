package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.model.MVCDTO;
import jspmvc.util.ConnectionUtil;

public class MVCGetDAO extends MVCAbstractDAO{

	@Override
	public MVCDTO get(int sid) {
	
		String sql = " select sid,title,content from jspmvc where sid=? ";
		
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = connUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			MVCDTO dto =null;
			if (rs != null) {
				if (rs.next()) {
					dto = new MVCDTO();
					dto.setSid(rs.getInt("sid"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
				}
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connUtil.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	
			}
		} //


	} // class
