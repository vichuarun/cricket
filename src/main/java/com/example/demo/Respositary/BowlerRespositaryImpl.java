package com.example.demo.Respositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.model.Bowler;
@Repository
public class BowlerRespositaryImpl implements BowlerRespositary{
	
	
	

	private static final String INSERTBOWLER_QUERY="INSERT INTO bowler(name,age,phoneno,totgame,totbowlruns,totbowlball,totwicket,bowlavg,bowleco) values(?,?,?,?,?,?,?,?,?)";
	private static final String GET_BOWLER_QUERY="SELECT * FROM bowler ";
	private static final String GET_BOWLER_BY_ID="SELECT * FROM bowler WHERE ID=?";
	private static final String UPDATE_BOWLER_QUERY="UPDATE bowler SET name=? ,age=?,phoneno=?,totgame=?,totbowlruns=?,totbowlball=?,totwicket=?,bowlavg=?,bowleco=? WHERE id=? ";
	private static final String GET_BEST_BOWLER="select * from bowler where bowlavg=(select MAX(bowlavg) from bowler)";
	private static final String DELETE_BOWLER_BY_ID_QUERY="DELETE FROM bowler WHERE ID=?";
	
@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	@Override
	public int saveBowler(Bowler bowler) {
		float bowlavg=(bowler.getTotbowlruns()/bowler.getTotgame());
		bowler.setBowlavg(bowlavg);
		
		float bowleco=(bowler.getTotbowlball()/bowler.getTotwicket());
		bowler.setBowleco(bowleco);
		
		
		return jdbctemplate.update(INSERTBOWLER_QUERY,
		new Object[] {bowler.getName(),bowler.getAge(),bowler.getPhoneno(),bowler.getTotgame(),
				bowler.getTotbowlruns(),bowler.getTotbowlball(),bowler.getTotwicket(),bowler.getBowlavg(),bowler.getBowleco()} );
		
	
	}
	@Override
	public int updateBowler(Bowler bowler) {
		float bowlavg=(bowler.getTotbowlruns()/bowler.getTotgame());
		bowler.setBowlavg(bowlavg);
		
		float bowleco=(bowler.getTotbowlball()/bowler.getTotwicket());
		bowler.setBowleco(bowleco);
		
		return jdbctemplate.update(UPDATE_BOWLER_QUERY,
		new Object[] {bowler.getName(),bowler.getAge(),bowler.getPhoneno(),bowler.getTotgame(),
				bowler.getTotbowlruns(),bowler.getTotbowlball(),bowler.getTotwicket(),bowler.getBowlavg(),bowler.getBowleco(),bowler.getId()} );
		
	
	}

	@Override
	public Bowler getById(Long id) {

			try
			{
				Bowler bowler=jdbctemplate.queryForObject(GET_BOWLER_BY_ID,
						BeanPropertyRowMapper.newInstance(Bowler.class),id);
			return bowler;
				
			}catch (Exception e) {
				throw new ResourceNotfFound("not found   :"+id); 
				// TODO: handle exception
			}
	}
	
	
	/*
	 * try {
	 * 
	 * Batsman batsman=jdbctemplate.queryForObject(GET_BATSMAN_BY_ID,
	 * BeanPropertyRowMapper.newInstance(Batsman.class),id); return batsman;
	 * 
	 * }catch (Exception e ) { //e.printStackTrace();
	 * 
	 * throw new ResourceNotfFound("not found   :"+id); }
	 * 
	 */
	
	@Override
	public Bowler getBestBowler() {


		try
		{
			Bowler bowler=jdbctemplate.queryForObject(GET_BEST_BOWLER,
					BeanPropertyRowMapper.newInstance(Bowler.class));
		return bowler;
			
		}catch (Exception e) {
		
			return null;
			// TODO: handle exception
		}
	}
	

	@Override
	public String deleteBowler(Long id) {
		
			 jdbctemplate.update(DELETE_BOWLER_BY_ID_QUERY,id);
			 
			 return "Bowler got deleted with id :"+id;
		
	}

	@Override
	public List<Bowler> allBowler() {
		
		
		return jdbctemplate.query(GET_BOWLER_QUERY, BeanPropertyRowMapper.newInstance(Bowler.class));
	}

}
