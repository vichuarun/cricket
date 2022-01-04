package com.example.demo.model;


public class Keeper extends Batsman{
	
	private int totcatch;
	private int totstump;
	private int bkeeper;
	public Keeper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Keeper(int totcatch, int totstump, int bkeeper) {
		super();
		this.totcatch = totcatch;
		this.totstump = totstump;
		this.bkeeper = bkeeper;
	}
	public Keeper(long id, String name, int age, long phoneno, int totgame, int totruns, int totball, float batavg,
			float batstrik, int totcatch, int totstump, int bkeeper) {
		super(id, name, age, phoneno, totgame, totruns, totball, batavg, batstrik);
		this.totcatch = totcatch;
		this.totstump = totstump;
		this.bkeeper = bkeeper;
	}
	public int getTotcatch() {
		return totcatch;
	}
	public void setTotcatch(int totcatch) {
		this.totcatch = totcatch;
	}
	public int getTotstump() {
		return totstump;
	}
	public void setTotstump(int totstump) {
		this.totstump = totstump;
	}
	public int getBkeeper() {
		return bkeeper;
	}
	public void setBkeeper(int bkeeper) {
		this.bkeeper = bkeeper;
	}
	@Override
	public String toString() {
		return "Keeper [totcatch=" + totcatch + ", totstump=" + totstump + ", bkeeper=" + bkeeper + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
