package com.example.demo.Respositary;

import java.util.List;

import com.example.demo.model.Batsman;

public interface BatsmanRespositary {
	
	
	int saveBatsman(Batsman batsman);
	
	int updateBatsman(Batsman batsman);
	
	Batsman getById(Long id) ;
	
	public List<Batsman> getBestBatsman();
	
	String deleteBatsman(Long id);
	
	List<Batsman> allBatsman();
	

}
