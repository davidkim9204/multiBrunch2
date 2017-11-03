package dto;

public class UserVo {
	
	private int uId;
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uGender;
	private int uAge;
	private String uPreference;
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuGender() {
		return uGender;
	}
	public void setuGender(String uGender) {
		this.uGender = uGender;
	}
	public int getuAge() {
		return uAge;
	}
	public void setuAge(int uAge) {
		this.uAge = uAge;
	}
	public String getuPreference() {
		return uPreference;
	}
	public void setuPreference(String uPreference) {
		this.uPreference = uPreference;
	}
	@Override
	public String toString() {
		return "MemberVO [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword
				+ ", uGender=" + uGender + ", uAge=" + uAge + ", uPreference=" + uPreference + "]";
	}	
	
	
	
	
	
}