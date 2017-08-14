package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import kr.or.connect.reservation.dao.sqls.UserSqls;
>>>>>>> B_SungJiHyun_bb
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DetailBottom;
import kr.or.connect.reservation.dto.User;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.
    
    public UserDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); // Datasource를 주입
        this.insertAction = new SimpleJdbcInsert(dataSource)  // Datasource를 주입
                .withTableName("users")   // table명을 지정
                .usingGeneratedKeyColumns("id"); // pk 칼럼을 지정
    }
    
    public long insert(User user){
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        return insertAction.executeAndReturnKey(params).longValue();
    }
    
    public User SelectUser(String id) {
	    	try {
	    		Map<String, Object> params = new HashMap<String, Object>();
	        params.put("id", id);
	        return jdbc.queryForObject(UserSqls.SELECT_ID, params, rowMapper);
	    	}catch(EmptyResultDataAccessException e) {
	    		return null;
	    	}
=======
import kr.or.connect.reservation.domain.User;

@Repository
public class UserDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    public Integer insert(User user) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public User selectUser(String id) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return jdbc.queryForObject(UserSqls.SELECT_ID, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
//            throw new IllegalArgumentException();
        	return null;	//유저가 없는 경우 null 반환
        }
>>>>>>> B_SungJiHyun_bb
    }

}
