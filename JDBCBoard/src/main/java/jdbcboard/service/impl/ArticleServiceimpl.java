package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ArticleDAOimpl;
import jdbcboard.model.Article;
import jdbcboard.model.Member;
import jdbcboard.service.ArticleService;

public class ArticleServiceimpl implements ArticleService{
	
	private static ArticleServiceimpl articleServiceImpl = new ArticleServiceimpl();
	private ArticleDAOimpl articleDAOImpl;
	
	private ArticleServiceimpl() {
		articleDAOImpl = ArticleDAOimpl.getArticleDAOImpl();
	}
	
	public static ArticleServiceimpl getArticleServiceImpl() {
		return articleServiceImpl;
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDAOImpl.insertArticle(article);
	}
	
	@Override
	public List<Article> selectArticle(String searchBoard, String searchClass, String searchVal) {
		return articleDAOImpl.selectArticle(searchBoard, searchClass, searchVal);
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

	@Override
	public int increaseAvcnt(int aid) {
		return articleDAOImpl.increaseAvcnt(aid);
	}
	
}
