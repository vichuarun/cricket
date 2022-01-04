package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.Respositary.BatsmanRespositary;
import com.example.demo.model.Batsman;
@RestController
@CrossOrigin
public class BatsmanController {
	
	@Autowired
	BatsmanRespositary batsmanRespositary;
	@PostMapping("/batsman/add")
	public int addBatsman(@Valid @RequestBody Batsman batsman) {
		return batsmanRespositary.saveBatsman(batsman);
	}
	
	
	@PutMapping("/batsman/update/{id}")
	public ResponseEntity<String> updateBatsman(@PathVariable Long id,@RequestBody Batsman batsman) {
		Batsman bbatsman=batsmanRespositary.getById(id);
		
		if(bbatsman!=null)
		{
			bbatsman.setId(id);
			bbatsman.setName(batsman.getName());
			bbatsman.setAge(batsman.getAge());
			bbatsman.setPhoneno(batsman.getPhoneno());
			bbatsman.setTotgame(batsman.getTotgame());
			bbatsman.setTotruns(batsman.getTotruns());
			bbatsman.setTotball(batsman.getTotball());
			float batavg=(batsman.getTotruns()/batsman.getTotgame());
			bbatsman.setBatavg(batavg);
			
			float batstrick=((batsman.getTotball()*100)/batsman.getTotruns());
			bbatsman.setBatstrik(batstrick);
			
batsmanRespositary.updateBatsman(bbatsman);
return new ResponseEntity<>("Batsman updated sucessfully with id :"+id, HttpStatus.OK);

		}else {
			
			return new ResponseEntity<>("canont find id :"+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/batsman/list")
	public List<Batsman> getBatsman() {
		return batsmanRespositary.allBatsman();
	}
	
	@GetMapping("/batsman/list/{id}")
	public ResponseEntity<?> getBatsmanById(@PathVariable Long id) {
	
		Batsman batsman=batsmanRespositary.getById(id);
		
		
		
		if(batsman!=null) { 
			return new ResponseEntity<>(batsman,HttpStatus.OK);
			
		}
		 else {
			
			 return new ResponseEntity<>(new ResourceNotfFound("batsman not Exist id  :"+id),HttpStatus.NOT_FOUND);
			 
		 
		 } 		
		
	}

	
	@GetMapping("/batsman/bestbatsman")
	public ResponseEntity<List<Batsman>> getBestBatsman() {
	return new ResponseEntity<List<Batsman>>(batsmanRespositary.getBestBatsman(), HttpStatus.ACCEPTED);
		//return new ResponseEntity<List<Batsman>> (batsmanRespositary.getBestBatsman(),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@DeleteMapping("/batsman/deleted/{id}")
	public String  deleteBatsman(@PathVariable Long id) {
		
		
		
Batsman batsman=batsmanRespositary.getById(id);
		
		
		
		if(batsman!=null) { 
			return batsmanRespositary.deleteBatsman(id);
			
		}
		return null;
		
	}

}
