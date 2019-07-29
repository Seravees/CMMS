package com.hg.domain;

public class User {
	String accountID;
	String psd;
	String name;
	String tel;

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

	@Override
	public String toString() {
		return "User [accountID=" + accountID + ", psd=" + psd + ", name="
				+ name + ", tel=" + tel + "]";
	}

}
