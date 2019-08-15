package com.hg.domain;

public class Equipment {
	String equipmentNo;
	String equipmentType;
	String equipmentNameInside;
	String equipmentNameOutside;
	String accountStarttime;
	String equipmentState;
	String equipmentAddress;
	String equipmentGps;
	String equipmentRemark;

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentNameInside() {
		return equipmentNameInside;
	}

	public void setEquipmentNameInside(String equipmentNameInside) {
		this.equipmentNameInside = equipmentNameInside;
	}

	public String getEquipmentNameOutside() {
		return equipmentNameOutside;
	}

	public void setEquipmentNameOutside(String equipmentNameOutside) {
		this.equipmentNameOutside = equipmentNameOutside;
	}

	public String getAccountStarttime() {
		return accountStarttime;
	}

	public void setAccountStarttime(String accountStarttime) {
		this.accountStarttime = accountStarttime;
	}

	public String getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(String equipmentState) {
		this.equipmentState = equipmentState;
	}

	public String getEquipmentAddress() {
		return equipmentAddress;
	}

	public void setEquipmentAddress(String equipmentAddress) {
		this.equipmentAddress = equipmentAddress;
	}

	public String getEquipmentGps() {
		return equipmentGps;
	}

	public void setEquipmentGps(String equipmentGps) {
		this.equipmentGps = equipmentGps;
	}

	public String getEquipmentRemark() {
		return equipmentRemark;
	}

	public void setEquipmentRemark(String equipmentRemark) {
		this.equipmentRemark = equipmentRemark;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentNo=" + equipmentNo + ", equipmentType="
				+ equipmentType + ", equipmentNameInside="
				+ equipmentNameInside + ", equipmentNameOutside="
				+ equipmentNameOutside + ", accountStarttime="
				+ accountStarttime + ", equipmentState=" + equipmentState
				+ ", equipmentAddress=" + equipmentAddress + ", equipmentGps="
				+ equipmentGps + ", equipmentRemark=" + equipmentRemark + "]";
	}

}
