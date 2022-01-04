package com.example.demo.model;


public class Bowler extends Person{
	
	private int totgame;
	private int totbowlruns;
	private int totbowlball;
	private int totwicket;
	private float bowlavg;
	private float bowleco;
	public Bowler() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bowler(long id, String name, int age, long phoneno, int totgame, int totbowlruns, int totbowlball,
			int totwicket, float bowlavg, float bowleco) {
		super(id, name, age, phoneno);
		this.totgame = totgame;
		this.totbowlruns = totbowlruns;
		this.totbowlball = totbowlball;
		this.totwicket = totwicket;
		this.bowlavg = bowlavg;
		this.bowleco = bowleco;
	}
	public Bowler(int totgame, int totbowlruns, int totbowlball, int totwicket, float bowlavg, float bowleco) {
		super();
		this.totgame = totgame;
		this.totbowlruns = totbowlruns;
		this.totbowlball = totbowlball;
		this.totwicket = totwicket;
		this.bowlavg = bowlavg;
		this.bowleco = bowleco;
	}
	public int getTotgame() {
		return totgame;
	}
	public void setTotgame(int totgame) {
		this.totgame = totgame;
	}
	public int getTotbowlruns() {
		return totbowlruns;
	}
	public void setTotbowlruns(int totbowlruns) {
		this.totbowlruns = totbowlruns;
	}
	public int getTotbowlball() {
		return totbowlball;
	}
	public void setTotbowlball(int totbowlball) {
		this.totbowlball = totbowlball;
	}
	public int getTotwicket() {
		return totwicket;
	}
	public void setTotwicket(int totwicket) {
		this.totwicket = totwicket;
	}
	public float getBowlavg() {
		return bowlavg;
	}
	public void setBowlavg(float bowlavg) {
		this.bowlavg = bowlavg;
	}
	public float getBowleco() {
		return bowleco;
	}
	public void setBowleco(float bowleco) {
		this.bowleco = bowleco;
	}
	@Override
	public String toString() {
		return "Bowler [totgame=" + totgame + ", totbowlruns=" + totbowlruns + ", totbowlball=" + totbowlball
				+ ", totwicket=" + totwicket + ", bowlavg=" + bowlavg + ", bowleco=" + bowleco + ", toString()="
				+ super.toString() + "]";
	}
	

}
