package com.hg.domain;

public class MaintenanceRecords {
	String mRecordsId;
	String equipmentNo;
	String mStarttime;
	String mEndtime;
	String malfunctionId;
	String mManName;
	String mResultRecords;
	String mState;
	String mRemark;

	public String getmRecordsId() {
		return mRecordsId;
	}

	public void setmRecordsId(String mRecordsId) {
		this.mRecordsId = mRecordsId;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getmStarttime() {
		return mStarttime;
	}

	public void setmStarttime(String mStarttime) {
		this.mStarttime = mStarttime;
	}

	public String getmEndtime() {
		return mEndtime;
	}

	public void setmEndtime(String mEndtime) {
		this.mEndtime = mEndtime;
	}

	public String getMalfunctionId() {
		return malfunctionId;
	}

	public void setMalfunctionId(String malfunctionId) {
		this.malfunctionId = malfunctionId;
	}

	public String getmManName() {
		return mManName;
	}

	public void setmManName(String mManName) {
		this.mManName = mManName;
	}

	public String getmResultRecords() {
		return mResultRecords;
	}

	public void setmResultRecords(String mResultRecords) {
		this.mResultRecords = mResultRecords;
	}

	public String getmState() {
		return mState;
	}

	public void setmState(String mState) {
		this.mState = mState;
	}

	public String getmRemark() {
		return mRemark;
	}

	public void setmRemark(String mRemark) {
		this.mRemark = mRemark;
	}

	@Override
	public String toString() {
		return "MaintenanceRecords [mRecordsId=" + mRecordsId
				+ ", equipmentNo=" + equipmentNo + ", mStarttime=" + mStarttime
				+ ", mEndtime=" + mEndtime + ", malfunctionId=" + malfunctionId
				+ ", mManName=" + mManName + ", mResultRecords="
				+ mResultRecords + ", mState=" + mState + ", mRemark="
				+ mRemark + "]";
	}

}
