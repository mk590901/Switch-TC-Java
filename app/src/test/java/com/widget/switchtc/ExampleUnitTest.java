package com.widget.switchtc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testSwitch() {
        SwitchResetHelper hsmHelper = new SwitchResetHelper();
        hsmHelper.init();
        hsmHelper.run("TURN");
        hsmHelper.run("RESET");
        hsmHelper.run("TURN");
        hsmHelper.run("TURN");
        hsmHelper.run("RESET");
    }
}