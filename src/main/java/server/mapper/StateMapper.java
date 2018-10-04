package server.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import server.model.State;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateMapper implements RowMapper<State> {
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();
        state.setId(rs.getInt("state_ID"));
        state.setCode(rs.getString("CODE"));
        state.setName(rs.getString("NAME"));
        return state;
    }
}