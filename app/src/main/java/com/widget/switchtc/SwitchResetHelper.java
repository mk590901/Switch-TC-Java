package com.widget.switchtc;
import java.util.Arrays;
import java.util.List;

public class SwitchResetHelper {
    private final QHsmHelper helper_ = new QHsmHelper("switch");

    public SwitchResetHelper() {
        createHelper();
    }

    // void switchEntry(Object data) {
    // }
    //
    // void switchInit(Object data) {
    // }

    private void offEntry(Object data) {
        System.out.println("OFF");
    }

    private void offReset(Object data) {
        System.out.println("@RESET");
    }

    // void offExit(Object data) {
    // }

    private void offTurn(Object data) {
        System.out.println("OFF: TURN");
    }

    private void onEntry(Object data) {
        System.out.println("ON ");
    }

    // void onExit(Object data) {
    // }

    private void onTurn(Object data) {
        System.out.println("ON : TURN");
    }

    public void init() {
        helper_.post("init");
    }

    public void run(final String eventName) {
        helper_.post(eventName);
    }

    public String state() {
        return helper_.getState();
    }

    private void createHelper() {
        helper_.insert("switch", "init", new ThreadedCodeExecutor(helper_, "off", List.of(
                // this::switchEntry,
                // this::switchInit,
                this::offEntry
        )));
        helper_.insert("off", "RESET", new ThreadedCodeExecutor(helper_, "off", List.of(
                this::offReset,
                // this::offExit,
                // this::switchInit,
                this::offEntry
        )));
        helper_.insert("off", "TURN", new ThreadedCodeExecutor(helper_, "on", List.of(
                this::offTurn,
                this::onEntry
        )));
        helper_.insert("on", "RESET", new ThreadedCodeExecutor(helper_, "off", List.of(
                this::offReset,
                // this::onExit,
                // this::offExit,
                // this::switchInit,
                this::offEntry
        )));
        helper_.insert("on", "TURN", new ThreadedCodeExecutor(helper_, "off", List.of(
                this::onTurn,
                // this::onExit,
                // this::offExit,
                // this::switchInit,
                this::offEntry
        )));
    }
}
