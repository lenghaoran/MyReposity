/**
 * 
 */
package com.clps.sms.sys.model;

import java.io.Serializable;
import java.util.Comparator;


public class Account implements Serializable,Comparator<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1104603544322025824L;
	private Integer acc_id; 
	private String acc_name; // ACC_NAME
	private String acc_password; // ACC_PASSWORD
	private String acc_email; // ACC_EMAIL
	private String acc_mobile; // ACC_MOBILE
	private String acc_dec; // ACC_DEC
	private Integer acc_status; // ACC_STATUS
	private String acc_created_date;
	private String acc_created_name;
	private String acc_update_date;
	private String acc_update_name;
	private Integer acc_role_id;
	/**
	 * 
	 */
	public Account() {
		super();
	}

	/**
	 * @return the acc_name
	 */
	public final String getAcc_name() {
		return acc_name;
	}

	/**
	 * 
	 * @param acc_name
	 *            the acc_name to set
	 */
	public final void setAcc_name(final String acc_name) {
		this.acc_name = acc_name;
	}

	/**
	 * @return the acc_password
	 */
	public final String getAcc_password() {
		return acc_password;
	}

	/**
	 * @param acc_password
	 *            the acc_password to set
	 */
	public final void setAcc_password(final String acc_password) {
		this.acc_password = acc_password;
	}

	/**
	 * @return the acc_email
	 */
	public final String getAcc_email() {
		return acc_email;
	}

	/**
	 * @param acc_email
	 *            the acc_email to set
	 */
	public final void setAcc_email(final String acc_email) {
		this.acc_email = acc_email;
	}

	/**
	 * @return the acc_mobile
	 */
	public final String getAcc_mobile() {
		return acc_mobile;
	}

	/**
	 * @param acc_mobile
	 *            the acc_mobile to set
	 */
	public final void setAcc_mobile(final String acc_mobile) {
		this.acc_mobile = acc_mobile;
	}

	/**
	 * @return the acc_dec
	 */
	public final String getAcc_dec() {
		return acc_dec;
	}

	/**
	 * @param acc_dec
	 *            the acc_dec to set
	 */
	public final void setAcc_dec(final String acc_dec) {
		this.acc_dec = acc_dec;
	}

	/**
	 * @return the acc_status
	 */
	public final Integer getAcc_status() {
		return acc_status;
	}

	/**
	 * @param acc_status
	 *            the acc_status to set
	 */
	public final void setAcc_status(final Integer acc_status) {
		this.acc_status = acc_status;
	}

	public Integer getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_created_date() {
		return acc_created_date;
	}

	public void setAcc_created_date(String acc_created_date) {
		this.acc_created_date = acc_created_date;
	}

	

	public String getAcc_update_date() {
		return acc_update_date;
	}

	public void setAcc_update_date(String acc_update_date) {
		this.acc_update_date = acc_update_date;
	}

	public Integer getAcc_role_id() {
		return acc_role_id;
	}

	public void setAcc_role_id(Integer acc_role_id) {
		this.acc_role_id = acc_role_id;
	}


	public String getAcc_created_name() {
		return acc_created_name;
	}

	public void setAcc_created_name(String acc_created_name) {
		this.acc_created_name = acc_created_name;
	}

	public String getAcc_update_name() {
		return acc_update_name;
	}

	public void setAcc_update_name(String acc_update_name) {
		this.acc_update_name = acc_update_name;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Account o1, Account o2) {
		if(o1.getAcc_name().compareTo(o2.getAcc_name())>0)
			return 1;
		else
			return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", acc_name=" + acc_name + ", acc_password=" + acc_password
				+ ", acc_email=" + acc_email + ", acc_mobile=" + acc_mobile + ", acc_dec=" + acc_dec + ", acc_status="
				+ acc_status + ", acc_created_date=" + acc_created_date + ", acc_created_name=" + acc_created_name
				+ ", acc_update_date=" + acc_update_date + ", acc_update_name=" + acc_update_name + ", acc_role_id="
				+ acc_role_id + "]";
	}

}
