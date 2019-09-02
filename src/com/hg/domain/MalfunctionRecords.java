package com.hg.domain;

public class MalfunctionRecords {
	String malfunctionId;
	String equipmentNo;
	String malfunctionMan;
	String malfunctionTime;
	String malfunctionRecords;
	String malfunctionState;
	String malfunctionStateName;

	public String getMalfunctionId() {
		return malfunctionId;
	}

	public void setMalfunctionId(String malfunctionId) {
		this.malfunctionId = malfunctionId;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getMalfunctionMan() {
		return malfunctionMan;
	}

	public void setMalfunctionMan(String malfunctionMan) {
		this.malfunctionMan = malfunctionMan;
	}

	public String getMalfunctionTime() {
		return malfunctionTime;
	}

	public void setMalfunctionTime(String malfunctionTime) {
		this.malfunctionTime = malfunctionTime;
	}

	public String getMalfunctionRecords() {
		return malfunctionRecords;
	}

	public void setMalfunctionRecords(String malfunctionRecords) {
		this.malfunctionRecords = malfunctionRecords;
	}

	public String getMalfunctionState() {
		return malfunctionState;
	}

	public void setMalfunctionState(String malfunctionState) {
		this.malfunctionState = malfunctionState;
	}

	public String getMalfunctionStateName() {
		return malfunctionStateName;
	}

	public void setMalfunctionStateName(String malfunctionStateName) {
		this.malfunctionStateName = malfunctionStateName;
	}

	@Override
	public String toString() {
		return "MalfunctionRecords [malfunctionId=" + malfunctionId
				+ ", equipmentNo=" + equipmentNo + ", malfunctionMan="
				+ malfunctionMan + ", malfunctionTime=" + malfunctionTime
				+ ", malfunctionRecords=" + malfunctionRecords
				+ ", malfunctionState=" + malfunctionState
				+ ", malfunctionStateName=" + malfunctionStateName + "]";
	}

}
