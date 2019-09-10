package com.hg.domain;

public class EquipmentType {
	String typeId;
	String typeName;
	String remark;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "EquipmentType [typeId=" + typeId + ", typeName=" + typeName
				+ ", remark=" + remark + "]";
	}

}
