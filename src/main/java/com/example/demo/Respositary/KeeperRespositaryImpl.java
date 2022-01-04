package com.example.demo.Respositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.model.Keeper;

@Repository
public class KeeperRespositaryImpl implements KeeperRespositary {

	private static final String INSERT_KEEPER_QUERY = "INSERT INTO keeper(name,age,phoneno,totgame,totruns,totball,batavg,batstrik,totcatch,totstump,bkeeper) values(?,?,?,?,?,?,?,?,?,?,?)";

	private static final String GET_KEEPER_QUERY = "SELECT * FROM keeper ";
	private static final String GET__KEEPER_BY_ID = "SELECT * FROM keeper WHERE ID=?";
	private static final String UPDATE__KEEPER_QUERY = "UPDATE keeper SET name=? ,age=?,phoneno=?,totgame=?,totruns=?,totball=?,batavg=?,batstrik=?,totcatch=?,tostump=?,bkeeper=? WHERE id=? ";
	private static final String GET_BEST__KEEPER = "select * from keeper where bkeeper=(select MAX(bkeeper) from keeper)";
	private static final String DELETE__KEEPER_BY_ID_QUERY = "DELETE FROM keeper WHERE ID=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveKeeper(Keeper keeper) {

		float batavg = (keeper.getTotruns() / keeper.getTotgame());
		keeper.setBatavg(batavg);

		float batstrick = ((keeper.getTotball() * 100) / keeper.getTotruns());
		keeper.setBatstrik(batstrick);

		int bkeeper = (keeper.getTotcatch() + keeper.getTotstump());
		keeper.setBkeeper(bkeeper);

		return jdbcTemplate.update(INSERT_KEEPER_QUERY,
				new Object[] { keeper.getName(), keeper.getAge(), keeper.getPhoneno(), keeper.getTotgame(),
						keeper.getTotruns(), keeper.getTotball(), keeper.getBatavg(), keeper.getBatstrik(),
						keeper.getTotcatch(), keeper.getTotstump(), keeper.getBkeeper() });

	}

	
	  @Override public int updateKeeper(Keeper keeper) { float
	  batavg=(keeper.getTotruns()/keeper.getTotgame()); keeper.setBatavg(batavg);
	  
	  float batstrick=((keeper.getTotball()*100)/keeper.getTotruns());
	  keeper.setBatstrik(batstrick);
	  
	  int bkeeper=(keeper.getTotcatch()+keeper.getTotstump());
	  keeper.setBkeeper(bkeeper);
	  
	  return jdbcTemplate.update(UPDATE__KEEPER_QUERY, new Object[]
	  {keeper.getName(),keeper.getAge(),keeper.getPhoneno(),keeper.getTotgame(),
	  keeper.getTotruns(),keeper.getTotball(),keeper.getBatavg(),keeper.getBatstrik
	  (),
	  keeper.getTotcatch(),keeper.getTotstump(),keeper.getBkeeper(),keeper.getId()}
	  );
	  
	  
	  }
	  
	 
	@Override
	public Keeper getById(Long id) {

		try {
			Keeper keeper = jdbcTemplate.queryForObject(GET__KEEPER_BY_ID,
					BeanPropertyRowMapper.newInstance(Keeper.class), id);
			return keeper;

		} catch (Exception e) {
			throw new ResourceNotfFound("not found   :"+id);
			// TODO: handle exception
		}
	}

	@Override
	public Keeper getBestKeeper() {

		try {
			Keeper keeper = jdbcTemplate.queryForObject(GET_BEST__KEEPER,
					BeanPropertyRowMapper.newInstance(Keeper.class));
			return keeper;

		} catch (Exception e) {

			return null;
			// TODO: handle exception
		}
	}

	@Override
	public String deleteKeeper(Long id) {

		jdbcTemplate.update(DELETE__KEEPER_BY_ID_QUERY, id);

		return "user got deleted with id :" + id;

	}

	@Override
	public List<Keeper> allKeeper() {

		return jdbcTemplate.query(GET_KEEPER_QUERY, BeanPropertyRowMapper.newInstance(Keeper.class));
	}

}
