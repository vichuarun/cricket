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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respositary.KeeperRespositary;
import com.example.demo.model.Keeper;
@RestController
public class KeeperController {
	
	
	@Autowired
	KeeperRespositary keeperRespositary;
	
	
	@PostMapping("/keeper/add")
	public int addKeeper(@RequestBody Keeper keeper) {
		return keeperRespositary.saveKeeper(keeper);
	}
	

	@PutMapping("/keeper/update/{id}")
	public ResponseEntity<String> updateKeeper(@PathVariable Long id,@RequestBody Keeper keeper) {
		Keeper kkeeper=keeperRespositary.getById(id);
		
		if(kkeeper!=null)
		{
			kkeeper.setId(id);
			kkeeper.setName(keeper.getName());
			kkeeper.setAge(keeper.getAge());
			kkeeper.setPhoneno(keeper.getPhoneno());
			kkeeper.setTotgame(keeper.getTotgame());
			kkeeper.setTotruns(keeper.getTotruns());
			kkeeper.setTotball(keeper.getTotball());
			
			kkeeper.setTotcatch(keeper.getTotcatch());
			kkeeper.setTotstump(keeper.getTotstump());
			float batavg=(keeper.getTotruns()/keeper.getTotgame());
			kkeeper.setBatavg(batavg);
			
			float batstrick=((keeper.getTotball()*100)/keeper.getTotruns());
			kkeeper.setBatstrik(batstrick);
			int bkeeper=(keeper.getTotcatch()+keeper.getTotstump());
			 kkeeper.setBkeeper(bkeeper);
			
keeperRespositary.updateKeeper(kkeeper)	;
return new ResponseEntity<>("keeper updated sucessfully with id :"+id, HttpStatus.OK);

		}else {
			
			return new ResponseEntity<>("canont find id :"+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	  @GetMapping("/keeper/list") public List<Keeper> getKeeper() { 
		  
		  return keeperRespositary.allKeeper(); 
		  
	  
	  }
	  
	  
	  @GetMapping("/keeper/list/{id}")
	  public ResponseEntity<Keeper> getKeeperById(@PathVariable Long id) {
	  
	  Keeper keeper=keeperRespositary.getById(id);
	  
	  if(keeper!=null) 
	  
	  { 
		  return new ResponseEntity<>(keeper,HttpStatus.OK);
		  }
	  
	 
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  
	  
	  
	  @GetMapping("/keeper/bestkeeper") 
	  public Keeper getBestKeeper()
	  {
	  
	  return keeperRespositary.getBestKeeper();
	  }
	  
	  @DeleteMapping("/keeper/deleted/{id}") public String deleteKeeper(@PathVariable
	  Long id) { return keeperRespositary.deleteKeeper(id); }
	  
	 
}
