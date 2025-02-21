package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.service.ArticleService;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.ArticleServiceimpl;
import jdbcboard.service.impl.MemberServiceimpl;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		
		MemberService memberService = MemberServiceimpl.getMemberServiceImpl();
		
		// insert
//		Member member = new Member("hong", "홍길동", "홍두깨", "1234", "hong@h.com", "010-123-3234","N");
//		int result = memberService.insertMember(member);
//		if(result>0) {
//			System.out.println("입력 성그엉~");
//		}
//		
		// update SET MNAME=?, MALIAS=?, MPASS=?, MEMAIL=?, MCP=?, WHERE MID=?
		Member member = new Member("hong", "name", "malias","mpass" ,"memail", "mcp", null);
		int result = memberService.updateMember(member);
		if(result>0) System.out.println("수정 성공");
		
		
		
//		// delete
//		int result = memberService.deleteMember(2);
//		if (result>0) {
//			System.out.println("삭제성공");
//		}
//
		// select
//		List<Member> memberList = memberService.selectMember();
//		for(Member member : memberList) {
//			System.out.println(member);
//		}
//		
//		// get
//		Member membe = memberService.getMember(1);
//		System.out.println(member);
//		
		
		
		
		
		
	}

}
