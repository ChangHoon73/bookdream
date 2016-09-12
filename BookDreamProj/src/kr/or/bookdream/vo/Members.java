package kr.or.bookdream.vo;

public class Members {
	private int no;
	private String email;
	private String pw;
	private String name;
	private String tel;
	private String sido;
	private String gugun;
	private String dong;
	private String registdate;
	private String authdate;
	private int sticker;
	
	
	public Members(int no, String email, String pw, String name, String tel, String sido, String gugun, String dong,
			String registdate, String authdate, int sticker) {
		super();
		this.no = no;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.registdate = registdate;
		this.authdate = authdate;
		this.sticker = sticker;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getSido() {
		return sido;
	}


	public void setSido(String sido) {
		this.sido = sido;
	}


	public String getGugun() {
		return gugun;
	}


	public void setGugun(String gugun) {
		this.gugun = gugun;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getRegistdate() {
		return registdate;
	}


	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}


	public String getAuthdate() {
		return authdate;
	}


	public void setAuthdate(String authdate) {
		this.authdate = authdate;
	}


	public int getSticker() {
		return sticker;
	}


	public void setSticker(int sticker) {
		this.sticker = sticker;
	}
	
}
