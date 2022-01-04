package com.example.demo.Respositary;

import java.util.List;

import com.example.demo.model.Bowler;

public interface BowlerRespositary {

	

	int saveBowler(Bowler bowler);
	
	int updateBowler(Bowler bowler);
	
	Bowler getById(Long id);
	
	Bowler getBestBowler();
	
	String deleteBowler(Long id);
	
	List<Bowler> allBowler();
	
	
}
