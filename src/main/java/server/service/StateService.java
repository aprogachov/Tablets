package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOstateImpl;
import server.DAO.StateDao;
import server.mapper.StateMapper;
import server.model.State;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

	@Autowired
	private StateDao stateDao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addState(State state) {
		stateDao.addState(state);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public State findById(int stateId) {
		State dbstate = stateDao.findById(stateId);
		return dbstate;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<State> findAllStates() {
		List<State> states = stateDao.findAllStates();
		return states;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateState(State state) {
		stateDao.updateState(state);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteState(State state) {
		stateDao.deleteState(state);
	}
}
