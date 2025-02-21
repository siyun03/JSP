package blog;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 2389478239738928L;

	private int authorId;
	private String authorUsername;
	private String authorPassword;
	private String authorEmail;
	private String authorBio;
	private String authorFavouriteSection;

	public Author() {
	}

	public Author(int authorId, String authorUsername, String authorPassword, String authorEmail, String authorBio,
			String authorFavouriteSection) {
		super();
		this.authorId = authorId;
		this.authorUsername = authorUsername;
		this.authorPassword = authorPassword;
		this.authorEmail = authorEmail;
		this.authorBio = authorBio;
		this.authorFavouriteSection = authorFavouriteSection;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public String getAuthorPassword() {
		return authorPassword;
	}

	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getAuthorBio() {
		return authorBio;
	}

	public void setAuthorBio(String authorBio) {
		this.authorBio = authorBio;
	}

	public String getAuthorFavouriteSection() {
		return authorFavouriteSection;
	}

	public void setAuthorFavouriteSection(String authorFavouriteSection) {
		this.authorFavouriteSection = authorFavouriteSection;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorUsername=" + authorUsername + ", authorPassword="
				+ authorPassword + ", authorEmail=" + authorEmail + ", authorBio=" + authorBio
				+ ", authorFavouriteSection=" + authorFavouriteSection + "]";
	}

}
