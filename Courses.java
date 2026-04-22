package models;

public class Courses {

	private int cid;
	private String name;
	private int credits;


	public Courses( String name, int credits) {
		//this.cid = cid;
		this.name = name;
		this.credits = credits;
	}
	public Courses(int cid, String name, int credits) {
		this.cid = cid;
		this.name = name;
		this.credits = credits;
	}

	public Courses() {}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}

}


