package kr.or.bookdream.vo;

public class SearchBooks {
	private String title;
	private String link;
	private String author;
	private String publisher;
	private String isbn;
	private String pdate;
	
	
	public SearchBooks(String title, String link, String author, String publisher, String isbn, String pdate) {
		this.title = title;
		this.link = link;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pdate = pdate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	
}
