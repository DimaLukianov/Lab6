package Lab6;

public class Groups {
	
	private int groupId;
	private String groupName;
	private int specId;
	
	Groups(int groupId, String groupName, int specId){
		this.setGroupId(groupId);
		this.setGroupName(groupName);
		this.setSpecId(specId);
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getSpecId() {
		return specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

}
