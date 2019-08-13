package com.hg.domain;

public class User {
	String accountID;
	String psd;
	String name;
	String tel;
	String accountGroupID;
	String accountGroupName;
	String secGroupID;

	public String getAccountGroupID() {
		return accountGroupID;
	}

	public void setAccountGroupID(String accountGroupID) {
		this.accountGroupID = accountGroupID;
	}

	public String getSecGroupID() {
		return secGroupID;
	}

	public void setSecGroupID(String secGroupID) {
		this.secGroupID = secGroupID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAccountGroupName() {
		return accountGroupName;
	}

	public void setAccountGroupName(String accountGroupName) {
		this.accountGroupName = accountGroupName;
	}

	@Override
	public String toString() {
		return "User [accountID=" + accountID + ", psd=" + psd + ", name="
				+ name + ", tel=" + tel + ", accountGroupID=" + accountGroupID
				+ ", accountGroupName=" + accountGroupName + ", secGroupID="
				+ secGroupID + "]";
	}

}
