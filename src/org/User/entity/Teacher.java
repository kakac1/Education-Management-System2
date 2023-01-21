package org.User.entity;

public class Teacher {
	private int id;
	private String iden_id;
	private String name;
	private String sex;
	private String birth;
	private String address;
	private String telnumber;
	private String pwd;
	private String sf;

	{
		this.sf = "老师";
		this.address = "无";
		this.telnumber = "无";
		this.pwd = "666666";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIden_id() {
		return iden_id;
	}

	public void setIden_id(String iden_id) {
		this.iden_id = iden_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public Teacher(int id, String iden_id, String name, String sex, String birth, String address, String telnumber,
			String pwd, String sf) {
		super();
		this.id = id;
		this.iden_id = iden_id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.address = address;
		this.telnumber = telnumber;
		this.pwd = pwd;
		this.sf = sf;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", iden_id=" + iden_id + ", name=" + name + ", sex=" + sex + ", birth=" + birth
				+ ", address=" + address + ", telnumber=" + telnumber + ", pwd=" + pwd + ", sf=" + sf + "]";
	}

}
