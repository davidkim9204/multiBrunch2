package dto;

public class Restaurant {
	private int rId;
	private String rName;
	private String rAddress;
	private int rDistance;
	private String rOpenHours;
	private String rTel;
	private int rRate;
	private String rCategory;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public int getrDistance() {
		return rDistance;
	}
	public void setrDistance(int i) {
		rDistance = i;
	}
	public String getrOpenHours() {
		return rOpenHours;
	}
	public void setrOpenHours(String rOpenHours) {
		this.rOpenHours = rOpenHours;
	}
	public String getrTel() {
		return rTel;
	}
	public void setrTel(String rTel) {
		this.rTel = rTel;
	}
	public int getrRate() {
		return rRate;
	}
	public void setrRate(int rRate) {
		this.rRate = rRate;
	}
	public String getrCategory() {
		return rCategory;
	}
	public void setrCategory(String rCategory) {
		this.rCategory = rCategory;
	}
	@Override
	public String toString() {
		return "Restaurant [rId=" + rId + ", rName=" + rName + ", rAddress=" + rAddress + ", Distance=" + rDistance
				+ ", rOpenHours=" + rOpenHours + ", rTel=" + rTel + ", rRate=" + rRate + ", rCategory=" + rCategory
				+ "]";
	}
	
}
