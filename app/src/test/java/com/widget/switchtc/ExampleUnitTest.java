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
        Switch_resetHelper hsmHelper = new Switch_resetHelper();
        assertEquals(hsmHelper.state(), "switch");
        hsmHelper.init();
        assertEquals(hsmHelper.state(), "off");
        hsmHelper.run("TURN");
        assertEquals(hsmHelper.state(), "on");
        hsmHelper.run("RESET");
        assertEquals(hsmHelper.state(), "off");
        hsmHelper.run("TURN");
        assertEquals(hsmHelper.state(), "on");
        hsmHelper.run("TURN");
        assertEquals(hsmHelper.state(), "off");
        hsmHelper.run("RESET");
        assertEquals(hsmHelper.state(), "off");
    }
}