package blog;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Post implements Serializable {

	private static final long serialVersionUID = 87887894789234398L;

	private int postId;
	private Timestamp postCreatedOn;
	private String postSection;
	private String postSubject;
	private int postDraft;
	private Author postAuthor;
	private List<Cmt> postComments;
	private List<Tag> postTags;
	private String postBody;
	private int postBlogId;
	private int postAuthorId;

	public Post() {
	}

	public Post(int postId, Timestamp postCreatedOn, String postSection, String postSubject, int postDraft,
			Author postAuthor, List<Cmt> postComments, List<Tag> postTags, String postBody, int postBlogId,
			int postAuthorId) {
		super();
		this.postId = postId;
		this.postCreatedOn = postCreatedOn;
		this.postSection = postSection;
		this.postSubject = postSubject;
		this.postDraft = postDraft;
		this.postAuthor = postAuthor;
		this.postComments = postComments;
		this.postTags = postTags;
		this.postBody = postBody;
		this.postBlogId = postBlogId;
		this.postAuthorId = postAuthorId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Timestamp getPostCreatedOn() {
		return postCreatedOn;
	}

	public void setPostCreatedOn(Timestamp postCreatedOn) {
		this.postCreatedOn = postCreatedOn;
	}

	public String getPostSection() {
		return postSection;
	}

	public void setPostSection(String postSection) {
		this.postSection = postSection;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

	public int getPostDraft() {
		return postDraft;
	}

	public void setPostDraft(int postDraft) {
		this.postDraft = postDraft;
	}

	public Author getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(Author postAuthor) {
		this.postAuthor = postAuthor;
	}

	public List<Cmt> getPostComments() {
		return postComments;
	}

	public void setPostComments(List<Cmt> postComments) {
		this.postComments = postComments;
	}

	public List<Tag> getPostTags() {
		return postTags;
	}

	public void setPostTags(List<Tag> postTags) {
		this.postTags = postTags;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public int getPostBlogId() {
		return postBlogId;
	}

	public void setPostBlogId(int postBlogId) {
		this.postBlogId = postBlogId;
	}

	public int getPostAuthorId() {
		return postAuthorId;
	}

	public void setPostAuthorId(int postAuthorId) {
		this.postAuthorId = postAuthorId;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postCreatedOn=" + postCreatedOn + ", postSection=" + postSection
				+ ", postSubject=" + postSubject + ", postDraft=" + postDraft + ", postAuthor=" + postAuthor
				+ ", postComments=" + postComments + ", postTags=" + postTags + ", postBody=" + postBody
				+ ", postBlogId=" + postBlogId + ", postAuthorId=" + postAuthorId + "]";
	}

}
