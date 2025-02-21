package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ArticleDAOimpl;
import jdbcboard.dao.impl.BoardDAOimpl;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.service.BoardService;

public class BoardServiceimpl implements BoardService{
	
	private static BoardServiceimpl articleServiceImpl = new BoardServiceimpl();
	private BoardDAOimpl boardDAOImpl;
	
	private BoardServiceimpl() {
		boardDAOImpl = BoardDAOimpl.getBoardDAOImpl();
	}
	
	public static BoardServiceimpl getBoardServiceImpl() {
		return articleServiceImpl;
	}
	
	
	@Override
	public int insertBoard(Board board) {
		return boardDAOImpl.insertBoard(board);
	}
	
	@Override
	public List<Board> selectBoard() {
		return boardDAOImpl.selectBoard();
	}

	@Override
	public Board getBoard(int bid) {
		return boardDAOImpl.getBoard(bid);
	}
	
	@Override
	public int updateBoard(Board board) {
		return boardDAOImpl.updateBoard(board);
	}
	@Override
	public int deleteBoard(int bid) {
		return boardDAOImpl.deleteBoard(bid);
	}
	
}
