package jdbcboard.test;

import jdbcboard.model.Member;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.MemberServiceimpl;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		
		MemberService memberService = new MemberServiceimpl();
		Member member = new Member("hong", "홍길동", "홍두깨", "1234", "hong@h.com", "010-123-3234","N");
		System.out.println(member);
		int result = memberService.insertMember(member);
		if(result>0) {
			System.out.println("입력 성그엉~");
		}
		
		
		
		
		
		
	}

}
