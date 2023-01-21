package org.User.entity;

public class Advise {
	private int id;
	private String adv;
	private String telnumber;
	private String sf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdv() {
		return adv;
	}

	public void setAdv(String adv) {
		this.adv = adv;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public Advise(int id, String adv, String telnumber, String sf) {
		super();
		this.id = id;
		this.adv = adv;
		this.telnumber = telnumber;
		this.sf = sf;
	}

	@Override
	public String toString() {
		return "Advise [id=" + id + ", adv=" + adv + ", telnumber=" + telnumber + ", sf=" + sf + "]";
	}

}
