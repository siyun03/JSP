package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.service.BoardService;
import jdbcboard.util.ConnectionUtil;

public class BoardDAOimpl implements BoardDAO{
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader("D:/jee_workspace/JDBCBoard/src/main/webapp/WEB-INF/props/sql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertBoard(Board board) {
		return BoardDAO.super.insertBoard(board);
	}
	
	@Override
	public List<Board> selectBoard() {
		return BoardDAO.super.selectBoard();
	}
	
	@Override
	public Board getBoard(int bid) {
		return BoardDAO.super.getBoard(bid);
	}
	
	@Override
	public int updateBoard(Board board) {
		return BoardDAO.super.updateBoard(board);
	}
	
	@Override
	public int deleteBoard(int bid) {
		return BoardDAO.super.deleteBoard(bid);
	}

}
