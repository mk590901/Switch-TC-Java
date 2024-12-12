package com.widget.switchtc;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    private final Queue<EventWrapper> _eventsQueue = new LinkedList<>();
    private final IQHsmStateMachineHelper _helper;
    private String targetState;

    public Runner(IQHsmStateMachineHelper helper) {
        this._helper = helper;
    }

    public void post(String event, Object data) {
        // System.out.println("post.addQueue [" + event + "(" + data + ")]");
        _eventsQueue.add(new EventWrapper(event, data));
        while (!_eventsQueue.isEmpty()) {
            EventWrapper eventWrapper = _eventsQueue.remove();
            // System.out.println("post event [" + eventWrapper.event() + ", " + eventWrapper.data() + "]");
            ThreadedCodeExecutor executor = _helper.executor(eventWrapper.event());
            if (executor != null) {
                executor.executeSync(data);
            }
        }
    }

    public void post(String event) {
        post(event, null);
    }
}
