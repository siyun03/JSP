package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.BoardServiceimpl;
import jdbcboard.service.impl.MemberServiceimpl;

public class BoardServiceTest {
	
	public static void main(String[] args) {
		BoardService boardService = new BoardServiceimpl();
		
//		// insert
//		Board board = new Board(0, "자유게시판", 0);
//		int result = boardService.insertBoard(board);
//		if(result>0) {
//			System.out.println("등록성공!");
//		}
		
		// update
		Board board = new Board(1, "(수정)자유게시판", 3);
		int result = boardService.updateBoard(board);
		if(result>0) System.out.println("수정 성공");
//		
//		
//		// delete
//		int result = boardService.deleteBoard(2);
//		if (result>0) {
//			System.out.println("삭제성공");
//		}
//
//		// select
//		List<Board> boardList = boardService.selectBoard();
//		for(Board board : boardList) {
//			System.out.println(board);
//		}
//		
//		// get
//		Board board = boardService.getBoard(1);
//		System.out.println(board);
		
		
		
	}

}
