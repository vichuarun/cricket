package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respositary.BowlerRespositary;
import com.example.demo.model.Bowler;


@RestController
public class BowlerController {
	
	
	@Autowired
	private BowlerRespositary bowlerRespositary;
	@PostMapping("/bowler")
	public int addBatsman(@Valid @RequestBody Bowler bowler) {
		return bowlerRespositary.saveBowler(bowler);
	}
	
	
	@PutMapping("/bowler/update/{id}")
	public ResponseEntity<String> updateBatsman(@PathVariable Long id,@RequestBody Bowler bowler) {
		Bowler bbowler=bowlerRespositary.getById(id);
		
		if(bbowler!=null)
		{
			bbowler.setId(id);
			bbowler.setName(bowler.getName());
			bbowler.setAge(bowler.getAge());
			bbowler.setPhoneno(bowler.getPhoneno());
			bbowler.setTotgame(bowler.getTotgame());
			bbowler.setTotbowlruns(bowler.getTotbowlruns());
			
			bbowler.setTotbowlball(bowler.getTotbowlball());
			bbowler.setTotwicket(bbowler.getTotwicket());
			
			float balllavg=(bowler.getTotbowlruns()/bowler.getTotgame());
			bbowler.setBowlavg(balllavg);
			
			float batstrick=(bowler.getTotbowlruns()/bowler.getTotwicket());
			bbowler.setBowleco(batstrick);
			
			bowlerRespositary.updateBowler(bbowler)	;
return new ResponseEntity<>("Bowler updated sucessfully with id :"+id, HttpStatus.OK);

		}else {
			
			return new ResponseEntity<>("canont find id :"+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/bowler/list")
	public List<Bowler> getBowler() {
		return bowlerRespositary.allBowler();
	}
	
	
	
	
	@GetMapping("/bowler/list/{id}")
	public ResponseEntity<Bowler> getBowlerById(@PathVariable Long id) {
	
		Bowler bowler=bowlerRespositary.getById(id);
		if(bowler!=null)
		{
			return new ResponseEntity<>(bowler,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/bowler/bestbowler")
	public Bowler getBestBowler() {
	
		return bowlerRespositary.getBestBowler();
	}
	
	@DeleteMapping("/bowler/deleted/{id}")
	public String deleteBowler(@PathVariable Long id) {
		
		Bowler bowler=bowlerRespositary.getById(id);
		if(bowler!=null)
		{
			return bowlerRespositary.deleteBowler(id);
		}
	return null;
		
	}

	

}
