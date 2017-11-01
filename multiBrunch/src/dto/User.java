package dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 새 테이블 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class User implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** uId. */
	private Integer uid;

	/** uName. */
	private String uname;

	/** uEmail. */
	private String uemail;

	/** uPassword. */
	private String upassword;

	/** uGender. */
	private String ugender;

	/** uAge. */
	private Integer uage;

	/** uPreference. */
	private String upreference;

	/** 새 테이블 목록. */
	private Set<Comment> commentSet;

	/**
	 * 생성자.
	 */
	public User() {
		this.commentSet = new HashSet<Comment>();
	}

	/**
	 * uId을 설정합니다..
	 * 
	 * @param uid
	 *            uId
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * uId을 가져옵니다..
	 * 
	 * @return uId
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 * uName을 설정합니다..
	 * 
	 * @param uname
	 *            uName
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * uName을 가져옵니다..
	 * 
	 * @return uName
	 */
	public String getUname() {
		return this.uname;
	}

	/**
	 * uEmail을 설정합니다..
	 * 
	 * @param uemail
	 *            uEmail
	 */
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	/**
	 * uEmail을 가져옵니다..
	 * 
	 * @return uEmail
	 */
	public String getUemail() {
		return this.uemail;
	}

	/**
	 * uPassword을 설정합니다..
	 * 
	 * @param upassword
	 *            uPassword
	 */
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	/**
	 * uPassword을 가져옵니다..
	 * 
	 * @return uPassword
	 */
	public String getUpassword() {
		return this.upassword;
	}

	/**
	 * uGender을 설정합니다..
	 * 
	 * @param ugender
	 *            uGender
	 */
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	/**
	 * uGender을 가져옵니다..
	 * 
	 * @return uGender
	 */
	public String getUgender() {
		return this.ugender;
	}

	/**
	 * uAge을 설정합니다..
	 * 
	 * @param uage
	 *            uAge
	 */
	public void setUage(Integer uage) {
		this.uage = uage;
	}

	/**
	 * uAge을 가져옵니다..
	 * 
	 * @return uAge
	 */
	public Integer getUage() {
		return this.uage;
	}

	/**
	 * uPreference을 설정합니다..
	 * 
	 * @param upreference
	 *            uPreference
	 */
	public void setUpreference(String upreference) {
		this.upreference = upreference;
	}

	/**
	 * uPreference을 가져옵니다..
	 * 
	 * @return uPreference
	 */
	public String getUpreference() {
		return this.upreference;
	}

	/**
	 * 새 테이블 목록을 설정합니다..
	 * 
	 * @param commentSet
	 *            새 테이블 목록
	 */
	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}

	/**
	 * 새 테이블를 추가합니다..
	 * 
	 * @param comment
	 *            새 테이블
	 */
	public void addComment(Comment comment) {
		this.commentSet.add(comment);
	}

	/**
	 * 새 테이블 목록을 가져옵니다..
	 * 
	 * @return 새 테이블 목록
	 */
	public Set<Comment> getCommentSet() {
		return this.commentSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		return true;
	}

}
