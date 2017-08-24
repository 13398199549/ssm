package org.framestudy.ssm.pojos;
/**
 * 下拉框封装对象
 * @author pu
 *
 */
public class DataBox {

	private String id;
	private String text;
	public DataBox() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataBox(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "DataBox [id=" + id + ", text=" + text + "]";
	}
	
	
}
