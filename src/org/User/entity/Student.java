package org.User.entity;

public class Student {
	private int id;
	private String xh;
	private String Uname;
	private String password;
	private String sex;
	private String birth;
	private int num;
	private String bj;
	private String address;
	private int credit;
	private String sf;
	private String number;
	private String tea;
	{
        
		birth = "200-6-1";
		num = 1;
		bj = "一班";
		address = "无";
		credit = 0;
		sf = "学生";
		number = "无";
		tea = "无";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getxh() {
		return xh;
	}

	public void setxh(String xh) {
		this.xh = xh;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getbj() {

		return bj;
	}

	public void setClass(String class1) {
		bj = class1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String gettea() {
		return tea;
	}

	public void settea(String tea) {
		this.tea = tea;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", xh=" + xh + ", Uname=" + Uname + ", password=" + password + ", sex=" + sex
				+ ", birth=" + birth + ", num=" + num + ", bj=" + bj + ", address=" + address + ", credit=" + credit
				+ ", sf=" + sf + ", number=" + number + ", tea=" + tea + "]";
	}

	public Student(int id, String xh, String uname, String password, String sex, String birth, int num, String bj,
			String address, int credit, String sf, String number) {
		super();
		this.id = id;
		this.xh = xh;
		Uname = uname;
		this.password = password;
		this.sex = sex;
		this.birth = birth;
		this.num = num;
		this.bj = bj;
		this.address = address;
		this.credit = credit;
		this.sf = sf;
		this.number = number;
	}

	public Student(int id, String xh, String uname, String password, String sex, String birth, int num, String bj,
			String address, int credit, String sf, String number, String tea) {
		super();
		this.id = id;
		this.xh = xh;
		Uname = uname;
		this.password = password;
		this.sex = sex;
		this.birth = birth;
		this.num = num;
		this.bj = bj;
		this.address = address;
		this.credit = credit;
		this.sf = sf;
		this.number = number;
		this.tea = tea;
	}

	public Student() {
		super();
	}

	public Student(String xh2, String name, String pwd, String sex2, String birth2, int num2, String class1,
			String adress, int credit2, String sf2, String number2, String tea2) {
		// TODO Auto-generated constructor stub
	}

}
