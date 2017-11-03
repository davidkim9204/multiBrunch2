package dto;

import java.io.Serializable;

/**
 * 새 테이블 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Comment implements Serializable {

	private int id;
	private int num;
	private String content;
	private String writer;
	private int RestaurantNum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getRestaurantNum() {
		return RestaurantNum;
	}
	public void setRestaurantNum(int RestaurantNum) {
		this.RestaurantNum = RestaurantNum;
	}
	@Override
	public String toString() {
		return "CommentVO [id=" + id + ", num=" + num + ", content=" + content + ", writer=" + writer + ", RestaurantNum="
				+ RestaurantNum + "]";
	}


}
