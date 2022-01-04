package com.example.demo.Respositary;

import java.util.List;

import com.example.demo.model.Allrounder;

public interface AlroundRespositary {

	

	int saveAllrounder(Allrounder allrounder);
	
	int updateAllrounder(Allrounder allrounder);
	
	Allrounder getById(Long id);
	
	Allrounder getBestAllrounder();
	
	String deleteAllrounder(Long id);
	
	List<Allrounder> allAllrounder();
}
