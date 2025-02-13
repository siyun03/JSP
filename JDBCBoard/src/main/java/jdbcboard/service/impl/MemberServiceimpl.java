package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.MemberDAOimpl;
import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

public class MemberServiceimpl implements MemberService{
	
	// 멤버 서비스 임플 > dao임플을 가지고있어야함 has a 관계
	private MemberDAOimpl memberDAOImpl;
	
	public MemberServiceimpl() {
		memberDAOImpl = new MemberDAOimpl();
	}
	
	@Override
	public int insertMember(Member member) {
		return memberDAOImpl.insertMember(member);
	}

	@Override
	public List<Member> selectMember() {
		return memberDAOImpl.selectMember();
	}

	@Override
	public Member getMember(String mid) {
		return  memberDAOImpl.getMember(mid);
	}

	@Override
	public int updateMember(Member member) {
		return memberDAOImpl.updateMember(member);
	}

	@Override
	public int deleteMember(String mid) {
		return  memberDAOImpl.deleteMember(mid);
	}

}
