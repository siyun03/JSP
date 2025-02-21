package jdbcboard.test;

import java.sql.Timestamp;
import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.service.ArticleService;
import jdbcboard.service.impl.ArticleServiceimpl;

public class ArticleServiceTest {
	
	public static void main(String[] args) {
		ArticleService articleService = ArticleServiceimpl.getArticleServiceImpl();

		
		// insert
	//	for (int i=0; i<101; i++) {
		Article article = new Article(0, "LCK", "4월시작", 3, 587, 2003, null,"N","kim", 1,"32");
		int result = articleService.insertArticle(article);
	//	}
		if(result>0) {
			System.out.println("등록성공!");
		}
//		
		// update
//		Article article = new Article(1, "LPL","ddagua",1, 0, 0, null, null, null, 0);
//		int result = articleService.updateArticle(article);
//		if(result>0) System.out.println("수정 성공");
//		
//		// delete
//		int result = articleService.deleteArticle(2);
//		if (result>0) {
//			System.out.println("삭제성공");
//		}
//
//		// select
//		List<Article> articleList = articleService.selectArticle();
//		for(Article article : articleList) {
//			System.out.println(article);
//		}
//		
//		// get
//		Article article = articleService.getArticle(1);
//		System.out.println(article);
		
		
		
	}

}
