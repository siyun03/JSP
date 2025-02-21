package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.util.ConnectionUtil;

public class MemberDAOimpl implements MemberDAO{

	private static MemberDAOimpl memberDAOImpl = new MemberDAOimpl();
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private MemberDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
			System.out.println(sqlProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static MemberDAOimpl getMemberDAOImpl() {
		return memberDAOImpl;
	}
	
	@Override
	public int insertMember(Member member) {
		try {
			String sql = sqlProperties.getProperty("INSERT_MEMBER");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMalias());
			pstmt.setString(4, member.getMpass());
			pstmt.setString(5, member.getMemail());
			pstmt.setString(6, member.getMcp());
			pstmt.setString(7, "N");
			int result = pstmt.executeUpdate();
			return result;
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
		try {
			String sql = sqlProperties.getProperty("SELECT_MEMBER");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Member> memberList = new ArrayList<>();
			while(rs.next()) {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMalias(rs.getString("malias"));
				member.setMpass(rs.getString("mpass"));
				member.setMid(rs.getString("mid"));
				member.setMemail(rs.getString("memail"));
				member.setMcp(rs.getString("mcp"));
				member.setMdelyn(rs.getString("mdelyn"));
				memberList.add(member);
			}
			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public Member getMember(String mid) {
		try {
			String sql = sqlProperties.getProperty("GET_MEMBER");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMalias(rs.getString("malias"));
				member.setMpass(rs.getString("mpass"));
				member.setMemail(rs.getString("memail"));
				member.setMcp(rs.getString("mcp"));
				member.setMdelyn(rs.getString("mdelyn"));
			}
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public int updateMember(Member member) {
		try {
			String sql = sqlProperties.getProperty("UPDATE_MEMBER");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMalias());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMcp());
			pstmt.setString(5, member.getMid());
			int result = pstmt.executeUpdate();
			return result;
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
	public int deleteMember(String mid) {
		try {
			String sql = sqlProperties.getProperty("DELETE_MEMBER");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			int result = pstmt.executeUpdate();
			return result;
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
	public boolean checkLogin(String mid, String mpass) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("CHECKLOGIN_MEMBER"));
			pstmt.setString(1, mid);
			pstmt.setString(2, mpass);
			rs = pstmt.executeQuery();
			
			if(rs.next() && rs.getInt("cnt")>0) return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
