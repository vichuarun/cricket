package com.example.demo.Respositary;

import java.util.List;

import com.example.demo.model.Keeper;

public interface KeeperRespositary {

	
	int saveKeeper(Keeper keeper);
	
	
int updateKeeper(Keeper keeper);
	
	Keeper getById(Long id);
	
	Keeper getBestKeeper();
	
	String deleteKeeper(Long id);
	
	List<Keeper> allKeeper();
}
