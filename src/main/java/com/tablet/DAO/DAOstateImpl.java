package com.tablet.DAO;

import com.tablet.model.State;
import com.tablet.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.*;
import java.util.Map;

@Repository
public class DAOstateImpl implements StateDao {

	private JdbcTemplate jdbcTemplate;
	public DataSource ds;

	@Autowired
	public DAOstateImpl(JdbcTemplate jdbcTemplate, DataSource ds) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = ds;
	}

	@Override
	public void addState(State state) {
		try {
			String sql = "INSERT INTO states(CODE, NAME) VALUES (?,?)";
			jdbcTemplate.update(sql, state.getCode(), state.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public State findById(int stateId) {
		String sql = "SELECT * FROM states WHERE STATE_ID = ?";
		State state = jdbcTemplate.queryForObject(sql, new Object[] { stateId }, new StateMapper());
		return state;
	}

	@Override
	public List<State> findAllStates() {
		List<State> states = new ArrayList<State>();
		try {
			String sql = "SELECT * FROM states";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				State state = new State();
				state.setId(Integer.parseInt(String.valueOf(row.get("STATE_ID"))));
				state.setCode((String)row.get("CODE"));
				state.setName((String)row.get("NAME"));
				states.add(state);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}

	@Override
	public void updateState(State state) {
		try {
			String sql = "UPDATE states SET CODE=?, NAME=? WHERE STATE_ID=?";
			jdbcTemplate.update(sql, state.getCode(), state.getName(), state.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteState(State state) {
		try {
			String sql = "DELETE FROM states WHERE STATE_ID=?";
			jdbcTemplate.update(sql, state.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
