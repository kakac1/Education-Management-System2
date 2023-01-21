package org.User.entity;

public class Manage {
	private int id;// id
	private String iden_id;// 编号
	private String name;// 姓名
	private String telnumber;// 电话号码
	private String pwd;// 密码
	private String sf;

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

	public Manage(int id, String iden_id, String name, String telnumber, String pwd, String sf) {
		super();
		this.id = id;
		this.iden_id = iden_id;
		this.name = name;
		this.telnumber = telnumber;
		this.pwd = pwd;
		this.sf = sf;
	}

	@Override
	public String toString() {
		return "manage [id=" + id + ", iden_id=" + iden_id + ", name=" + name + ", telnumber=" + telnumber + ", pwd="
				+ pwd + ", sf=" + sf + "]";
	}

}
