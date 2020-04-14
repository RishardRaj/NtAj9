package com.nt;

public class ResultGenerator {
	//bean properties
	private int sno,total,nos;
	private String sname,result;
	private  float avg;
	
	public ResultGenerator() {
	  System.out.println("ResultGenerator: 0-param constructor");
	}
	//setters and getters

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNos() {
		return nos;
	}

	public void setNos(int nos) {
		this.nos = nos;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}
	//B.metho
	public void calcResult(){
		 avg=total/nos;
		 if(avg<35)
			 result="fail";
		 else 
			 result="pass";
	}
}
