package com.widget.switchtc;

import java.util.HashMap;
import java.util.Map;

public class QHsmHelper implements IQHsmStateMachineHelper {
    private String _state;
    private final Runner runner;
    private final Map<String, ThreadedCodeExecutor> _container = new HashMap<>();

    public QHsmHelper(String state) {
        this._state = state;
        this.runner = new Runner(this);
    }

    public void insert(String state, String event, ThreadedCodeExecutor executor) {
        _container.put(createKey(state, event), executor);
    }

    public void post(String event, Object data) {
        runner.post(event, data);
    }

    public void post(String event) {
        post(event, null);
    }

    @Override
    public ThreadedCodeExecutor executor(String event) {
        String key = createKey(_state, event);
        if (!_container.containsKey(key)) {
            System.out.println("runSync.error: " + _state + "->" + event);
            return null;
        }
        ThreadedCodeExecutor executor = _container.get(key);
        // executor.trace(_state, event);
        return executor;
    }

    @Override
    public String getState() {
        return _state;
    }

    @Override
    public void setState(String state) {
        // System.out.println("******* QHsmHelper.setState " + _state + "->" + state + " *******");
        _state = state;
    }

    private String createKey(String state, String event) {
        // Assuming createKey is a method that concatenates state and event with a delimiter
        return state + ":" + event;
    }
}
