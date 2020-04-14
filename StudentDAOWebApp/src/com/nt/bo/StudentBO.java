package com.nt.bo;

public class StudentBO {
 private int sno;
 private String sname;
 private int total;
 private float avg;
 private String result;
 
 public StudentBO() {
   System.out.println("StudentBO:0-param constructor");
}
public StudentBO(int sno, String sname, int total, float avg, String result) {
	  System.out.println("StudentBO:5-param constructor");
	this.sno = sno;
	this.sname = sname;
	this.total = total;
	this.avg = avg;
	this.result = result;
}



public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public float getAvg() {
	return avg;
}

public void setAvg(float avg) {
	this.avg = avg;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}
 
 
}
