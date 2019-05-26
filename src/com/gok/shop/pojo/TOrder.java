package com.gok.shop.pojo;

import java.util.Date;

public class TOrder {
	private Integer order_Id;
	
	private String order_Code;

	private String suser;

	private String uid;

	private Date dgdate;

	private String spaytype;

	private String ssendtype;

	private Integer nmcsize;

	private String ntotalprice;

	private String sstatus;

	private String smsg;

	private Integer sauser;

	private Date dadate;

	private String ssname;

	private String ssaddress;

	private String sscode;

	private String ssphone;

	public Integer getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(Integer orderId) {
		this.order_Id = orderId;
	}

	public String getOrder_Code() {
		return order_Code;
	}

	public void setOrder_Code(String orderCode) {
		this.order_Code = orderCode;
	}

	public String getSuser() {
		return suser;
	}

	public void setSuser(String suser) {
		this.suser = suser;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDgdate() {
		return dgdate;
	}

	public void setDgdate(Date dgdate) {
		this.dgdate = dgdate;
	}

	public String getSpaytype() {
		return spaytype;
	}

	public void setSpaytype(String spaytype) {
		this.spaytype = spaytype;
	}

	public String getSsendtype() {
		return ssendtype;
	}

	public void setSsendtype(String ssendtype) {
		this.ssendtype = ssendtype;
	}

	public Integer getNmcsize() {
		return nmcsize;
	}

	public void setNmcsize(Integer nmcsize) {
		this.nmcsize = nmcsize;
	}

	public String getNtotalprice() {
		return ntotalprice;
	}

	public void setNtotalprice(String ntotalprice) {
		this.ntotalprice = ntotalprice;
	}

	public String getSstatus() {
		return sstatus;
	}

	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}

	public String getSmsg() {
		return smsg;
	}

	public void setSmsg(String smsg) {
		this.smsg = smsg;
	}

	public Integer getSauser() {
		return sauser;
	}

	public void setSauser(Integer sauser) {
		this.sauser = sauser;
	}

	public Date getDadate() {
		return dadate;
	}

	public void setDadate(Date dadate) {
		this.dadate = dadate;
	}

	public String getSsname() {
		return ssname;
	}

	public void setSsname(String ssname) {
		this.ssname = ssname;
	}

	public String getSsaddress() {
		return ssaddress;
	}

	public void setSsaddress(String ssaddress) {
		this.ssaddress = ssaddress;
	}

	public String getSscode() {
		return sscode;
	}

	public void setSscode(String sscode) {
		this.sscode = sscode;
	}

	public String getSsphone() {
		return ssphone;
	}

	public void setSsphone(String ssphone) {
		this.ssphone = ssphone;
	}

	
}
