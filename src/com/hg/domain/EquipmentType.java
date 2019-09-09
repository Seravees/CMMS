package com.hg.domain;

public class EquipmentType {
	String typeId;
	String name;
	String remark;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "EquipmentType [typeId=" + typeId + ", name=" + name
				+ ", remark=" + remark + "]";
	}

}
