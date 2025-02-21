package jdbcboard.test;

import java.sql.Timestamp;
import java.util.List;

import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.ArticleService;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.ReplyService;
import jdbcboard.service.impl.ArticleServiceimpl;
import jdbcboard.service.impl.BoardServiceimpl;
import jdbcboard.service.impl.MemberServiceimpl;
import jdbcboard.service.impl.ReplyServiceimpl;

public class ReplyServiceTest {
	
	public static void main(String[] args) {
		ReplyService replyService = ReplyServiceimpl.getReplyServiceImpl();
		
		// insert
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Reply reply = new Reply(0, "대댓글", time, "N","hong",1);
		int result = replyService.insertReply(reply);
		if(result>0) {
			System.out.println("등록성공!");
		}
		
		// update
//		Reply reply = new Reply(2, "내용수정", null, null, null, 0);
//		int result = replyService.updateReply(reply);
//		if(result>0) System.out.println("수정 성공");
//		
//		
//		// delete
//		int result = replyService.deleteReply(2);
//		if (result>0) {
//			System.out.println("삭제성공");
//		}
//
//		// select
//		List<Reply> replyList = replyService.selectReply();
//		for(Reply reply  : replyList) {
//			System.out.println(reply);
//		}
//		
//		// get
//		Reply reply = replyService.getReply(2);
//		System.out.println(reply);
//		
		
		
	}

}
