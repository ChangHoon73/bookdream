package kr.or.bookdream.vo;

public class Books {
	private int no;
	private String title;
	private String isbn;
	private String author;
	private String publisher;
	private String pdate;
	private int edition = 1;
	private String status;
	private String link;
	private String regidate;
	private int rpoint = 0;
	private int members_no;
	private int category1_no;
	private int category2_no;
	
	public Books(int no, String title, String isbn, String author, String publisher, String pdate, int edition,
			String status, String link, String regidate, int rpoint, int members_no, int category1_no,
			int category2_no) {
		super();
		this.no = no;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.pdate = pdate;
		this.edition = edition;
		this.status = status;
		this.link = link;
		this.regidate = regidate;
		this.rpoint = rpoint;
		this.members_no = members_no;
		this.category1_no = category1_no;
		this.category2_no = category2_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public int getRpoint() {
		return rpoint;
	}

	public void setRpoint(int rpoint) {
		this.rpoint = rpoint;
	}

	public int getMembers_no() {
		return members_no;
	}

	public void setMembers_no(int members_no) {
		this.members_no = members_no;
	}

	public int getCategory1_no() {
		return category1_no;
	}

	public void setCategory1_no(int category1_no) {
		this.category1_no = category1_no;
	}

	public int getCategory2_no() {
		return category2_no;
	}

	public void setCategory2_no(int category2_no) {
		this.category2_no = category2_no;
	}
	
	
	
	
}
