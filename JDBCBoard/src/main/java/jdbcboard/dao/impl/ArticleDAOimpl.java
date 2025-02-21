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
import jdbcboard.util.ConnectionUtil;

public class ArticleDAOimpl implements ArticleDAO {
	
	private static ArticleDAOimpl articleDAOImpl = new ArticleDAOimpl();
	
	Connection conn = null;
	Properties sqlProperties = null;	
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	private ArticleDAOimpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArticleDAOimpl getArticleDAOImpl() {
		return articleDAOImpl;
	}
	
	@Override
	public List<Article> selectArticle(String searchBoard, String searchClass, String searchVal) {
		try {
			String sql = sqlProperties.getProperty("SELECT_ARTICLE");
			
			if (searchBoard!=null && !searchBoard.equals("")) {
				sql += " AND A.BID=" + searchBoard + " ";
			}
			
			if (searchClass!=null) {
				if (searchClass.equals("")) {
					sql += " AND (ASUBJECT LIKE '%" + searchVal + "%' OR ";
					sql += " ACONTENT LIKE '%" + searchVal + "%' OR ";
					sql += " MID LIKE '%" + searchVal + "%') ";
				} else if (searchClass.equals("asubject")) {
					sql += " AND ASUBJECT LIKE '%" + searchVal + "%' ";
				} else if (searchClass.equals("acontent")) {
					sql += " AND ACONTENT LIKE '%" + searchVal + "%' ";
				} else if (searchClass.equals("mid")) {
					sql += " AND MID LIKE '%" + searchVal + "%' ";
				}
			}
			
			sql += " ORDER BY AID DESC ";
			
			//System.out.println("sql => " + sql);
			
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> articleList = new ArrayList<Article>();
			while (rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAcount(rs.getInt("acount"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
				article.setBname(rs.getString("bname"));
				articleList.add(article);
			}
			return articleList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
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
			if (rs.next()) {
				article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAcount(rs.getInt("acount"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
				article.setBname(rs.getString("bname"));
			}
			return article;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
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
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
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
			pstmt.setInt(3, article.getBid());
			pstmt.setInt(4, article.getAid());
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
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
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public int increaseAvcnt(int aid) {
		try {
			String sql = sqlProperties.getProperty("INCREASE_AVCNT");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}












