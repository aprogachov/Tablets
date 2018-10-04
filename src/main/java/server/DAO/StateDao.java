package server.DAO;

import server.model.State;
import java.util.List;

public interface StateDao {

    void addState(State state);
    State findById(int stateId);
    List<State> findAllStates();
    void updateState(State state);
    void deleteState(State state);
}
