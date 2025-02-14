package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.model.Board;
import jdbcboard.util.ConnectionUtil;

public class ArticleDAOimpl implements ArticleDAO{
	
	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArticleDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertArticle(Article article) {
		try {
			String sql = sqlProperties.getProperty("INSERT_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAcount());
			pstmt.setInt(4, article.getAvcnt());
			pstmt.setInt(5, article.getArcnt());
			pstmt.setString(6, article.getAdelyn());
			pstmt.setString(7, article.getMid());
			pstmt.setInt(8, article.getBid());
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Article> selectArticle() {
		try {
			String sql = sqlProperties.getProperty("SELECT_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> articleList = new ArrayList<>();
			while(rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAcount(rs.getInt("acount"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
				
				articleList.add(article);
			}
			return articleList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	}
	
	@Override
	public Article getArticle(int aid) {
		try {
			String sql = sqlProperties.getProperty("GET_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			rs = pstmt.executeQuery();
			Article article = null;
			if(rs.next()) {
				article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAcount(rs.getInt("acount"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
			}
			return article;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public int updateArticle(Article article) {
		try {
			String sql = sqlProperties.getProperty("UPDATE_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAid());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public int deleteArticle(int aid) {
		try {
			String sql = sqlProperties.getProperty("DELETE_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

}
