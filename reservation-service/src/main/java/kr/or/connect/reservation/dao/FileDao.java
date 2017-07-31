package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.domain.FileDomain;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.sqls.FileSqls.SELECT_FILE_ADDR;

@Repository
public class FileDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<FileDomain> rowMapper = BeanPropertyRowMapper.newInstance(FileDomain.class);

    public FileDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("file")
                .usingGeneratedKeyColumns("id");
    }

    public FileDomain selectFileAddr(Integer id) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return jdbc.queryForObject(SELECT_FILE_ADDR, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer addFile(FileDomain fileDomain) {
        System.out.println(fileDomain);
        SqlParameterSource param = new BeanPropertySqlParameterSource(fileDomain);
        return insertAction.executeAndReturnKey(param).intValue();

    }
}
