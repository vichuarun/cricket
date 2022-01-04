package com.example.demo.Respositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.model.Allrounder;

public class AlroundRespositaryImpl implements AlroundRespositary{
	
	

	private static final String INSERT_ALROUND_QUERY="INSERT INTO alround(name,age,phoneno,totgame,totruns,totball,batavg,batstrik,totcatch,totstump,bkeeper,totbowlruns,totbowlball,totwicket,bowlavg,bowleco,ballroud) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALROUND_QUERY="SELECT * FROM alround ";
	private static final String GET_ALROUND_BY_ID="SELECT * FROM alround WHERE ID=?";
	private static final String UPDATE_ALROUND_QUERY="UPDATE alround SET name=? ,age=?,phoneno=?,totgame=?,totbowlruns=?,totbowlball=?,totwicket=?,bowlavg=?,bowleco=?totruns=?,totball=?,batavg=?,batstrik=?,totcatch=?,totstump=?,bkeeper=?,ballroud=? WHERE id=? ";
	private static final String GET_BEST_ALROUND="select * from alround where balround=(select MAX(balround) from alround";
	private static final String DELETE_ALROUND_BY_ID_QUERY="DELETE FROM alround WHERE ID=?";
	
@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	@Override
	public int saveAllrounder(Allrounder allrounder) {
		
		
		float bowlavg=(allrounder.getTotbowlruns()/allrounder.getTotgame());
		allrounder.setBowlavg(bowlavg);
		
		float bowleco=(allrounder.getTotbowlball()/allrounder.getTotwicket());
		allrounder.setBowleco(bowleco);
		
		
		return jdbctemplate.update(INSERT_ALROUND_QUERY,
		new Object[] {allrounder.getName(),allrounder.getAge(),allrounder.getPhoneno(),allrounder.getTotgame(),
				allrounder.getTotruns(),allrounder.getTotball(),allrounder.getBatavg(),allrounder.getBatstrik(),
				
				allrounder.getTotcatch(),allrounder.getTotstump(),allrounder.getBkeeper(),
				
				allrounder.getTotbowlruns(),allrounder.getTotbowlball(),allrounder.getTotwicket(),allrounder.getBowlavg(),allrounder.getBowleco()} );
		
	
	}
	@Override
	public int updateAllrounder(Allrounder allrounder) {
		float bowlavg=(allrounder.getTotbowlruns()/allrounder.getTotgame());
		allrounder.setBowlavg(bowlavg);
		
		float bowleco=(allrounder.getTotbowlball()/allrounder.getTotwicket());
		allrounder.setBowleco(bowleco);
		
		float batavg=(allrounder.getTotruns()/allrounder.getTotgame());
		allrounder.setBatavg(batavg);
		
		float batstrick=((allrounder.getTotball()*100)/allrounder.getTotruns());
		allrounder.setBatstrik(batstrick);
		
		int bkeeper = (allrounder.getTotcatch() + allrounder.getTotstump());
		allrounder.setBkeeper(bkeeper);
		
		float balround=(allrounder.getBatavg()+allrounder.getBowlavg()+allrounder.getBkeeper());
		allrounder.setBalround(balround);
		return jdbctemplate.update(UPDATE_ALROUND_QUERY,
				new Object[] {allrounder.getName(),allrounder.getAge(),allrounder.getPhoneno(),allrounder.getTotgame(),
						allrounder.getTotruns(),allrounder.getTotball(),allrounder.getBatavg(),allrounder.getBatstrik(),
						
						allrounder.getTotcatch(),allrounder.getTotstump(),allrounder.getBkeeper(),
						
						allrounder.getTotbowlruns(),allrounder.getTotbowlball(),allrounder.getTotwicket(),allrounder.getBowlavg(),allrounder.getBowleco()} );
				
	
	}

	@Override
	public Allrounder getById(Long id) {

			try
			{
				Allrounder allrounder=jdbctemplate.queryForObject(GET_ALROUND_BY_ID,
						BeanPropertyRowMapper.newInstance(Allrounder.class),id);
			return allrounder;
				
			}catch (Exception e) {
				throw new ResourceNotfFound("not found   :"+id);
				// TODO: handle exception
			}
	}
	
	
	@Override
	public Allrounder getBestAllrounder() {


		try
		{
			Allrounder allrounder=jdbctemplate.queryForObject(GET_BEST_ALROUND,
					BeanPropertyRowMapper.newInstance(Allrounder.class));
		return allrounder;
			
		}catch (Exception e) {
		
			return null;
			// TODO: handle exception
		}
	}
	

	@Override
	public String deleteAllrounder(Long id) {
		
			 jdbctemplate.update(DELETE_ALROUND_BY_ID_QUERY,id);
			 
			 return "Bowler got deleted with id :"+id;
		
	}

	@Override
	public List<Allrounder> allAllrounder() {
		
		
		return jdbctemplate.query(GET_ALROUND_QUERY, BeanPropertyRowMapper.newInstance(Allrounder.class));
	}


}
