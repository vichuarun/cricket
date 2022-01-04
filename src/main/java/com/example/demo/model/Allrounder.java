package com.example.demo.model;

public class Allrounder extends Bowler{

	private int totgame;
	
	private int totruns;
	
	private int totball;
	
	private float batavg;
	
	private float batstrik;
	private int totcatch;
	private int totstump;
	private int bkeeper;
	
	private float balround;
	
	
	public Allrounder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Allrounder(int totgame, int totruns, int totball, float batavg, float batstrik, int totcatch, int totstump,
			int bkeeper, float balround) {
		super();
		this.totgame = totgame;
		this.totruns = totruns;
		this.totball = totball;
		this.batavg = batavg;
		this.batstrik = batstrik;
		this.totcatch = totcatch;
		this.totstump = totstump;
		this.bkeeper = bkeeper;
		this.balround = balround;
	}


	public Allrounder(long id, String name, int age, long phoneno, int totgame, int totbowlruns, int totbowlball,
			int totwicket, float bowlavg, float bowleco, int totgame2, int totruns, int totball, float batavg,
			float batstrik, int totcatch, int totstump, int bkeeper, float balround) {
		super(id, name, age, phoneno, totgame, totbowlruns, totbowlball, totwicket, bowlavg, bowleco);
		totgame = totgame2;
		this.totruns = totruns;
		this.totball = totball;
		this.batavg = batavg;
		this.batstrik = batstrik;
		this.totcatch = totcatch;
		this.totstump = totstump;
		this.bkeeper = bkeeper;
		this.balround = balround;
	}


	public int getTotgame() {
		return totgame;
	}


	public void setTotgame(int totgame) {
		this.totgame = totgame;
	}


	public int getTotruns() {
		return totruns;
	}


	public void setTotruns(int totruns) {
		this.totruns = totruns;
	}


	public int getTotball() {
		return totball;
	}


	public void setTotball(int totball) {
		this.totball = totball;
	}


	public float getBatavg() {
		return batavg;
	}


	public void setBatavg(float batavg) {
		this.batavg = batavg;
	}


	public float getBatstrik() {
		return batstrik;
	}


	public void setBatstrik(float batstrik) {
		this.batstrik = batstrik;
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


	public float getBalround() {
		return balround;
	}


	public void setBalround(float balround) {
		this.balround = balround;
	}


	@Override
	public String toString() {
		return "Allrounder [totgame=" + totgame + ", totruns=" + totruns + ", totball=" + totball + ", batavg=" + batavg
				+ ", batstrik=" + batstrik + ", totcatch=" + totcatch + ", totstump=" + totstump + ", bkeeper="
				+ bkeeper + ", balround=" + balround + ", toString()=" + super.toString() + "]";
	}
	
}
