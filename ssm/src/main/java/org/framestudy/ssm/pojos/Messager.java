package org.framestudy.ssm.pojos;

public class Messager {

	private boolean status;
	private String info;
	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messager(boolean status, String info) {
		super();
		this.status = status;
		this.info = info;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Messager [status=" + status + ", info=" + info + "]";
	}
	
	
}
