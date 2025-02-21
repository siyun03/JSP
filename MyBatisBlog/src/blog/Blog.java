package blog;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

	private static final long serialVersionUID = 239898894789234398L;

	private int blogId;
	private String blogTitle;
	private Author blogAuthor;
	private List<Post> blogPosts;
	private int blogAuthorId;

	public Blog() {
	}

	public Blog(int blogId, String blogTitle, Author blogAuthor, List<Post> blogPosts, int blogAuthorId) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogAuthor = blogAuthor;
		this.blogPosts = blogPosts;
		this.blogAuthorId = blogAuthorId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public Author getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(Author blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public List<Post> getBlogPosts() {
		return blogPosts;
	}

	public void setBlogPosts(List<Post> blogPosts) {
		this.blogPosts = blogPosts;
	}

	public int getBlogAuthorId() {
		return blogAuthorId;
	}

	public void setBlogAuthorId(int blogAuthorId) {
		this.blogAuthorId = blogAuthorId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogAuthor=" + blogAuthor + ", blogPosts="
				+ blogPosts + ", blogAuthorId=" + blogAuthorId + "]";
	}

}
