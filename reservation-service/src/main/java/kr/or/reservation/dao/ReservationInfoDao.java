package kr.or.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.reservation.domain.Category;
import kr.or.reservation.domain.ReservationInfo;
import kr.or.reservation.dto.ReservationDTO;
<<<<<<< HEAD
=======
import kr.or.reservation.sqls.ReservationInfoSqls;
>>>>>>> 0d95395487ea32084ee49af481f7933ef7c9a78a
import kr.or.reservation.sqls.ReservationSqls;

@Repository
public class ReservationInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
		this.insertAction = new SimpleJdbcInsert(dataSource) 
				.withTableName("reservation_info") 
				.usingGeneratedKeyColumns("id"); 
	}
	
	public Long insert(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
<<<<<<< HEAD
=======
	public ReservationInfo selectById(int id) {
		Map<String , ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ReservationInfoSqls.SELECT_BY_ID, params, rowMapper);
	}
	
>>>>>>> 0d95395487ea32084ee49af481f7933ef7c9a78a
	

}
