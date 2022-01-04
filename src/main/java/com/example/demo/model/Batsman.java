package com.example.demo.model;


public class Batsman extends Person{
	
	
	private int totgame;
	
	
	private int totruns;
	
	
	private int totball;
	
	
	private float batavg;
	
	
	private float batstrik;

	

	public Batsman() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Batsman(int totgame, int totruns, int totball, float batavg, float batstrik) {
		super();
		this.totgame = totgame;
		this.totruns = totruns;
		this.totball = totball;
		this.batavg = batavg;
		this.batstrik = batstrik;
	}


	public Batsman(long id, String name, int age, long phoneno, int totgame, int totruns, int totball, float batavg,
			float batstrik) {
		super(id, name, age, phoneno);
		this.totgame = totgame;
		this.totruns = totruns;
		this.totball = totball;
		this.batavg = batavg;
		this.batstrik = batstrik;
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



}
