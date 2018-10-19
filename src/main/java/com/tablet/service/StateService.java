package com.tablet.service;

import com.tablet.DAO.StateDao;
import com.tablet.model.State;
import com.tablet.util.Audit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StateService implements IStateService  {

	@Autowired
	private StateDao stateDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Add state")
	public void addState(State state) {
		stateDao.addState(state);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "FindById state")
	public State findById(int stateId) {
		State dbstate = stateDao.findById(stateId);
		return dbstate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Find all states")
	public List<State> findAllStates() {
		List<State> states = stateDao.findAllStates();
		return states;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Update state")
	public void updateState(State state) {
		stateDao.updateState(state);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete state")
	public void deleteState(State state) {
		stateDao.deleteState(state);
	}
}
