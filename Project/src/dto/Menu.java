package dto;

public class Menu {
	private int mId;
	private String mName;
	private int mPrice;
	private String mPicture1;
	private String mPicture2;
	private int rId;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public String getmPicture1() {
		return mPicture1;
	}
	public void setmPicture1(String mPicture1) {
		this.mPicture1 = mPicture1;
	}
	public String getmPicture2() {
		return mPicture2;
	}
	public void setmPicture2(String mPicture2) {
		this.mPicture2 = mPicture2;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	@Override
	public String toString() {
		return "Menu [mId=" + mId + ", mName=" + mName + ", mPrice=" + mPrice + ", mPicture1=" + mPicture1
				+ ", mPicture2=" + mPicture2 + ", rId=" + rId + "]";
	}
	
}
