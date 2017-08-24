package org.framestudy.ssm.beans;

import java.util.List;

public class Pager {

	private int total;//总条数
	private List<?> rows;
	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pager(int total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}


	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Pager [total=" + total + ", rows=" + rows + "]";
	}
	
}
