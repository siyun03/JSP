package jdbcboard.dao;

import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.model.Member;

public interface ArticleDAO {
	
	default List<Article> selectArticle(){return null;}
	
	default Article getArticle(int aid) {return null;}
	
	default int insertArticle(Article article) {return 0;}
	
	default int updateArticle(Article article) {return 0;}
	
	default int deleteArticle(int aid) {return 0;}

}
