package com.example.demo.Respositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.model.Batsman;
@Repository
public class BatsmanRespositaryImpl implements BatsmanRespositary{
	
	private static final String INSERT_USER_QUERY="INSERT INTO batsman(name,age,phoneno,totgame,totruns,totball,batavg,batstrik) values(?,?,?,?,?,?,?,?)";
	private static final String GET_BATSMAN_QUERY="SELECT * FROM batsman ";
	private static final String GET_BATSMAN_BY_ID="SELECT * FROM batsman WHERE ID=?";
	private static final String UPDATE_BATSMAN_QUERY="UPDATE batsman SET name=? ,age=?,phoneno=?,totgame=?,totruns=?,totball=?,batavg=?,batstrik=? WHERE id=? ";
	private static final String GET_BEST_BATSMAN="SELECT * FROM batsman WHERE batavg=(select MAX(batavg) FROM batsman)";
							
	private static final String DELETE_USER_BY_ID_QUERY="DELETE FROM batsman WHERE ID=?";
	
@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	@Override
	public int saveBatsman(Batsman batsman) {
		float batavg=(batsman.getTotruns()/batsman.getTotgame());
		batsman.setBatavg(batavg);
		
		float batstrick=((batsman.getTotball()*100)/batsman.getTotruns());
		batsman.setBatstrik(batstrick);
		
		return jdbctemplate.update(INSERT_USER_QUERY,
		new Object[] {batsman.getName(),batsman.getAge(),batsman.getPhoneno(),batsman.getTotgame(),
				batsman.getTotruns(),batsman.getTotball(),batsman.getBatavg(),batsman.getBatstrik()} );
		
	
	}
	@Override
	public int updateBatsman(Batsman batsman) {
		float batavg=(batsman.getTotruns()/batsman.getTotgame());
		batsman.setBatavg(batavg);
		
		float batstrick=((batsman.getTotball()*100)/batsman.getTotruns());
		batsman.setBatstrik(batstrick);
		
		return jdbctemplate.update(UPDATE_BATSMAN_QUERY,
		new Object[] {batsman.getName(),batsman.getAge(),batsman.getPhoneno(),batsman.getTotgame(),
				batsman.getTotruns(),batsman.getTotball(),batsman.getBatavg(),batsman.getBatstrik(),batsman.getId()} );
		
	
	}

	@Override
	public Batsman getById(Long id) throws ResourceNotfFound {

		
		try {
			
			Batsman batsman=jdbctemplate.queryForObject(GET_BATSMAN_BY_ID, BeanPropertyRowMapper.newInstance(Batsman.class),id);
				return batsman;
						
		}catch (Exception e ) {
			//e.printStackTrace();
			
			throw new ResourceNotfFound("not found   :"+id);
		}
		
		 
		}

	
	@Override
	public List<Batsman> getBestBatsman(){


			return  jdbctemplate.query(GET_BEST_BATSMAN,
					BeanPropertyRowMapper.newInstance(Batsman.class));
		
			
	
	}
	

	@Override
	public String deleteBatsman(Long id) {
		
			 jdbctemplate.update(DELETE_USER_BY_ID_QUERY,id);
			 
			 return "user got deleted with id :"+id;
		
	}

	@Override
	public List<Batsman> allBatsman() {
		
		
		return jdbctemplate.query(GET_BATSMAN_QUERY, BeanPropertyRowMapper.newInstance(Batsman.class));
	}
	
	
	
	
}



