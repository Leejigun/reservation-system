package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

<<<<<<< HEAD
=======
import kr.or.connect.reservation.dao.sqls.ReserveSqls;
>>>>>>> B_SungJiHyun_bb
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ReserveInfo;
=======
import kr.or.connect.reservation.domain.ReserveInfo;
>>>>>>> B_SungJiHyun_bb

@Repository
public class ReserveDao {
	
		private NamedParameterJdbcTemplate jdbc;
<<<<<<< HEAD
	    private SimpleJdbcInsert insertAction;
	    private RowMapper<ReserveInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReserveInfo.class); 
=======
	    private RowMapper<ReserveInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReserveInfo.class);
>>>>>>> B_SungJiHyun_bb
	    
	    public ReserveDao(DataSource dataSource) {
	        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	    }
	    
	    public List<ReserveInfo> selectReserveInfo(Integer id){
<<<<<<< HEAD
	    	 	Map<String, Object> params = new HashMap<String, Object>();
=======
	    	 	Map<String, Object> params = new HashMap<>();
>>>>>>> B_SungJiHyun_bb
	        params.put("id", id);
	        return jdbc.query(ReserveSqls.SELECT_RESERVE_INFO,params,rowMapper);
	    }
}
