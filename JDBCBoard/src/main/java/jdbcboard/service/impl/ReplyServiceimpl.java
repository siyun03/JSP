package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ArticleDAOimpl;
import jdbcboard.dao.impl.MemberDAOimpl;
import jdbcboard.dao.impl.ReplyDAOimpl;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;

public class ReplyServiceimpl implements ReplyService{

	private static ReplyServiceimpl replyServiceImpl = new ReplyServiceimpl();
	private ReplyDAOimpl replyDAOImpl;
	
	private ReplyServiceimpl() {
		replyDAOImpl = ReplyDAOimpl.getReplyDAOImpl();
	}
	
	public static ReplyServiceimpl getReplyServiceImpl() {
		return replyServiceImpl;
	}
	
	
	@Override
	public int insertReply(Reply reply) {
		return replyDAOImpl.insertReply(reply);
	}
	
	@Override
	public List<Reply> selectReply() {
		return replyDAOImpl.selectReply();
	}
	
	@Override
	public Reply getReply(int rid) {
		return replyDAOImpl.getReply(rid);
	}
	
	@Override
	public int updateReply(Reply reply) {
		return replyDAOImpl.updateReply(reply);
	}
	
	@Override
	public int deleteReply(int rid) {
		return replyDAOImpl.deleteReply(rid);
	}

}
