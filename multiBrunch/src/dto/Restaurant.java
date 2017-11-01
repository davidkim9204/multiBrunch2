package dto;


import java.util.Set;

public class Restaurant {

	private int rId;

	private String rName;

	private String rAddress;

	private int rDistance;

	private String rOpenhours;

	private String rTel;

	private int rRate;
	
	private String rCategory;

	private Set<Comment> commentSet;

	private Set<Menu> menuSet;

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

	public void setrDistance(int rDistance) {
		this.rDistance = rDistance;
	}

	public String getrOpenhours() {
		return rOpenhours;
	}

	public void setrOpenhours(String rOpenhours) {
		this.rOpenhours = rOpenhours;
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

	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}

	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}

	@Override
	public String toString() {
		return "Restaurant [rId=" + rId + ", rName=" + rName + ", rAddress=" + rAddress + ", rDistance=" + rDistance
				+ ", rOpenhours=" + rOpenhours + ", rTel=" + rTel + ", rRate=" + rRate + ", rCategory=" + rCategory
				+ ", commentSet=" + commentSet + ", menuSet=" + menuSet + "]";
	}




}
