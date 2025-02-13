package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Member;
import jdbcboard.util.ConnectionUtil;

public class MemberDAOimpl implements MemberDAO{
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader("D:\\jee_workspace\\JDBCBoard\\src\\main\\webapp\\WEB-INF\\props\\sql.properties"));
			System.out.println(sqlProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertMember(Member member) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("INSERT_MEMBER"));
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMpass());
			pstmt.setString(5, member.getMalias());
			pstmt.setString(6, member.getMcp());
			pstmt.setString(7, "N");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Member> selectMember() {
		return MemberDAO.super.selectMember();
	}
	
	@Override
	public Member getMember(String mid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("GET_MEMBER"));
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int updateMember(Member member) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("UPDATE_MEMBER"));
			pstmt.setString(1, mid);
			pstmt.setString(1, member.setMid(null));
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMpass());
			pstmt.setString(5, member.getMalias());
			pstmt.setString(6, member.getMcp());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	@Override
	public int deleteMember(String mid) {
		return MemberDAO.super.deleteMember(mid);
	}
	

}
