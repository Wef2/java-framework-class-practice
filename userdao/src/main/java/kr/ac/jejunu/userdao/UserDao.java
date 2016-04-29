package kr.ac.jejunu.userdao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.*;

/**
 * Created by Kim on 2016-03-25.
 */

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e){

        }
        return user;
    }

    public Long add(final User user){
        final String sql = "INSERT INTO user (name, password) values (?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassword());
                return preparedStatement;
            }
        }, generatedKeyHolder);
        return (Long) generatedKeyHolder.getKey();
    }

    public void update(User user) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE user SET name = ?, password = ? WHERE id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcTemplate.update(sql, params);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(sql, params);
    }

}