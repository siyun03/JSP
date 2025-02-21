package blog;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogTest {
	
	public static void main(String[] args) {
		
		String resource = "conf/configuration.xml";
		Reader reader = null;
		SqlSession session = null;
		
		try {
			
			reader = Resources.getResourceAsReader(resource);
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			session = sqlSessionFactory.openSession();
			
			// select
			List<Blog> blogList = session.selectList("Blog.selectBlogDetails", 1);
			for (Blog blog : blogList) {
				System.out.println(blog);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		
	} // main

} // class













