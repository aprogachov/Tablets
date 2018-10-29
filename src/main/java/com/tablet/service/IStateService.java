package com.tablet.service;

import com.modelsale.model.State;

import java.util.List;

public interface IStateService {

    void addState(State state);
    State findById(int stateId);
    List<State> findAllStates();
    void updateState(State state);
    void deleteState(State state);
}
