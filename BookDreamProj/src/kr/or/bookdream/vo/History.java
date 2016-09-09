package kr.or.bookdream.vo;

public class History {
	private int no;
	private String wdate;
	private int books_no;
	private int members_no;
	private String members_name;
	
	public History(int no, String wdate, int books_no, int members_no, String members_name) {
		super();
		this.no = no;
		this.wdate = wdate;
		this.books_no = books_no;
		this.members_no = members_no;
		this.members_name = members_name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getBooks_no() {
		return books_no;
	}

	public void setBooks_no(int books_no) {
		this.books_no = books_no;
	}

	public int getMembers_no() {
		return members_no;
	}

	public void setMembers_no(int members_no) {
		this.members_no = members_no;
	}

	public String getMembers_name() {
		return members_name;
	}

	public void setMembers_name(String members_name) {
		this.members_name = members_name;
	}
}
