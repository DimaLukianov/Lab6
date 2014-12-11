package Lab6;

public class Students {
	
	private String surName;
	private String name;
	private String fName;
	private int studId;
	private int groupId;
	
	Students (String surName, String name, String fName, int studId, int groupId){
		this.surName = surName;
		this.name = name;
		this.fName = fName;
		this.studId = studId;
		this.groupId = groupId;
	}
	
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fName;
	}
	public void setFname(String fName) {
		this.fName = fName;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGrupId(int groupId) {
		this.groupId = groupId;
	}

}
