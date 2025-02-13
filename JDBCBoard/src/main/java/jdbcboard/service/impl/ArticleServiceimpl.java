package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ArticleDAOimpl;
import jdbcboard.model.Article;
import jdbcboard.model.Member;
import jdbcboard.service.ArticleService;

public class ArticleServiceimpl implements ArticleService{
	
	private ArticleDAOimpl articleDAOImpl;
	
	public ArticleServiceimpl() {
		articleDAOImpl = new ArticleDAOimpl();
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDAOImpl.insertArticle(article);
	}
	
	@Override
	public List<Article> selectArticle() {
		return articleDAOImpl.selectArticle();
	}
	
	@Override
	public Article getArticle(int aid) {
		return articleDAOImpl.getArticle(aid);
	}
	
	@Override
	public int updateArticle(Article article) {
		return articleDAOImpl.updateArticle(article);
	}
	
	@Override
	public int deleteArticle(int aid) {
		return articleDAOImpl.deleteArticle(aid);
	}

}
