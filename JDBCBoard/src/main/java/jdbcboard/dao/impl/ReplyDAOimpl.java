package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.util.ConnectionUtil;

public class ReplyDAOimpl implements ReplyDAO{

	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ReplyDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader("D:/jee_workspace/JDBCBoard/src/main/webapp/WEB-INF/props/sql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertReply(Reply reply) {
		return ReplyDAO.super.insertReply(reply);
	}
	
	@Override
	public List<Reply> selectReply() {
		return ReplyDAO.super.selectReply();
	}
	
	@Override
	public Reply getReply(int rid) {
		return ReplyDAO.super.getReply(rid);
	}
	
	
	@Override
	public int updateReply(Reply reply) {
		return ReplyDAO.super.updateReply(reply);
	}
	
	@Override
	public int deleteReply(int rid) {
		return ReplyDAO.super.deleteReply(rid);
	}
	
}
