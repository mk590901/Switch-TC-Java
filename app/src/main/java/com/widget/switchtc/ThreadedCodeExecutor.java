package com.widget.switchtc;

import java.util.List;
import java.util.function.Consumer;

public class ThreadedCodeExecutor {
    private final Runner runner;
    private final List<Consumer<Object>> _functions;
    private final IQHsmStateMachineHelper _helper;
    private final String _targetState;

    public ThreadedCodeExecutor(IQHsmStateMachineHelper helper, String targetState, List<Consumer<Object>> functions) {
        this._helper = helper;
        this._targetState = targetState;
        this._functions = functions;
        this.runner = new Runner(helper);
    }

    public void post(String event, Object data) {
        runner.post(event, data);
    }

    public void post(String event) {
        post(event, null);
    }

    public void executeSync(Object data) {
        _helper.setState(_targetState);
        for (Consumer<Object> func : _functions) {
            func.accept(data);
        }
    }

    public void executeSync() {
        executeSync(null);
    }
}
