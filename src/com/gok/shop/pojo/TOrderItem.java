package com.gok.shop.pojo;


public class TOrderItem {
	  private Integer itemid;

	    private Integer order_id;

	    private Integer nid;

	    private Integer ncount;

	    private Float nprice;

	    private Float ntotalprice;

		public Integer getItemid() {
			return itemid;
		}

		public void setItemid(Integer itemid) {
			this.itemid = itemid;
		}

		public Integer getOrder_id() {
			return order_id;
		}

		public void setOrderId(Integer orderId) {
			this.order_id = orderId;
		}

		public Integer getNid() {
			return nid;
		}

		public void setNid(Integer nid) {
			this.nid = nid;
		}

		public Integer getNcount() {
			return ncount;
		}

		public void setNcount(Integer ncount) {
			this.ncount = ncount;
		}

		public Float getNprice() {
			return nprice;
		}

		public void setNprice(Float nprice) {
			this.nprice = nprice;
		}

		public Float getNtotalprice() {
			return ntotalprice;
		}

		public void setNtotalprice(Float ntotalprice) {
			this.ntotalprice = ntotalprice;
		}
	    
	    
}
