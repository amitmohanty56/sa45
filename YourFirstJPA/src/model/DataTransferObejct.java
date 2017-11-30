package model;

import java.io.Serializable;

public class DataTransferObejct implements Serializable {
	
	private int x;
	private String y;
	public DataTransferObejct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}

}
