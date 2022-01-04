package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Respositary.AlroundRespositary;
import com.example.demo.model.Allrounder;


public class AlroundController {

	@Autowired
	private AlroundRespositary alroundRespositary;
	@PostMapping("/alrounder")
	public int addBatsman(@RequestBody Allrounder allrounder) {
		return alroundRespositary.saveAllrounder(allrounder);
	}
	
	
	@PutMapping("/alrounder/update/{id}")
	public ResponseEntity<String> updateAllrounder(@PathVariable Long id,@RequestBody Allrounder allrounder) {
		Allrounder alrounder=alroundRespositary.getById(id);
		
		if(alrounder!=null)
		{
			alrounder.setId(id);
			alrounder.setName(allrounder.getName());
			alrounder.setAge(allrounder.getAge());
			alrounder.setPhoneno(allrounder.getPhoneno());
			alrounder.setTotgame(allrounder.getTotgame());
			alrounder.setTotbowlruns(allrounder.getTotbowlruns());
			
			alrounder.setTotbowlball(allrounder.getTotbowlball());
			alrounder.setTotwicket(allrounder.getTotwicket());
			
			float balllavg=(allrounder.getTotbowlruns()/allrounder.getTotgame());
			alrounder.setBowlavg(balllavg);
			
			float batstrick=(allrounder.getTotbowlruns()/allrounder.getTotwicket());
			alrounder.setBowleco(batstrick);
			
			alroundRespositary.updateAllrounder(alrounder)	;
return new ResponseEntity<>("Allrounder updated sucessfully with id :"+id, HttpStatus.OK);

		}else {
			
			return new ResponseEntity<>("canont find id :"+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/allrounder/list")
	public List<Allrounder> getAllrounder() {
		return alroundRespositary.allAllrounder();
	}
	
	@GetMapping("/allrounder/{id}")
	public ResponseEntity<Allrounder> getAllrounderById(@PathVariable Long id) {
	
		Allrounder allrounder=alroundRespositary.getById(id);
		if(allrounder!=null)
		{
			return new ResponseEntity<>(allrounder,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/allrounder/best")
	public Allrounder getBestAllrounder() {
	
		return alroundRespositary.getBestAllrounder();
	}
	
	@DeleteMapping("/allrounder/deleted/{id}")
	public String deleteAllrounder(@PathVariable Long id) {
		return alroundRespositary.deleteAllrounder(id);
	}

	

}

