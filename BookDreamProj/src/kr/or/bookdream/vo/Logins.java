package kr.or.bookdream.vo;

public class Logins {
	private int membersno;
	private String membersemail;
	private String membersname;
	private boolean bLogin;
	
	public Logins(int membersno, String membersemail, String membersname, boolean bLogin) {
		super();
		this.membersno = membersno;
		this.membersemail = membersemail;
		this.membersname = membersname;
		this.bLogin = bLogin;
	}
	
	public int getMembersno() {
		return membersno;
	}

	public void setMembersno(int membersno) {
		this.membersno = membersno;
	}

	public String getMembersemail() {
		return membersemail;
	}

	public void setMembersemail(String membersemail) {
		this.membersemail = membersemail;
	}

	public String getMembersname() {
		return membersname;
	}

	public void setMembersname(String membersname) {
		this.membersname = membersname;
	}

	public boolean isbLogin() {
		return bLogin;
	}

	public void setbLogin(boolean bLogin) {
		this.bLogin = bLogin;
	}
}
