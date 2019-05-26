package com.gok.shop.pojo;

import java.util.Date;

public class Product {
	 private Integer nid;

	    private String sname;

	    private String sdescription;

	    private Float nprice;

	    private String simg;

	    private Integer smctag;

	    private Date dcdate;

	    private Integer cateid;

		public Integer getNid() {
			return nid;
		}

		public void setNid(Integer nid) {
			this.nid = nid;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getSdescription() {
			return sdescription;
		}

		public void setSdescription(String sdescription) {
			this.sdescription = sdescription;
		}

		public Float getNprice() {
			return nprice;
		}

		public void setNprice(Float nprice) {
			this.nprice = nprice;
		}

		public String getSimg() {
			return simg;
		}

		public void setSimg(String simg) {
			this.simg = simg;
		}

		public Integer getSmctag() {
			return smctag;
		}

		public void setSmctag(Integer smctag) {
			this.smctag = smctag;
		}

		public Date getDcdate() {
			return dcdate;
		}

		public void setDcdate(Date dcdate) {
			this.dcdate = dcdate;
		}

		public Integer getCateid() {
			return cateid;
		}

		public void setCateid(Integer cateid) {
			this.cateid = cateid;
		}
	    
	    
}
