package com.widget.switchtc;

public interface IQHsmStateMachineHelper {
    String getState();
    void setState(String state);
    ThreadedCodeExecutor executor(String event);
}
