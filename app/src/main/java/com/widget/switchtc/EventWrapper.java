package com.widget.switchtc;

public class EventWrapper {

    private final Object _data;
    private final String _event;

    public EventWrapper(String event, Object data) {
        this._event = event;
        this._data = data;
    }

    public Object data() {
        return _data;
    }

    public String event() {
        return _event;
    }
}