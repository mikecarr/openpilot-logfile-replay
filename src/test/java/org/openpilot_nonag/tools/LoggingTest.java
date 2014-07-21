package org.openpilot_nonag.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggingTest {

    @Test
    public void testOpenFile() throws Exception {

        String filepath = "";
        Logging l = new Logging();
        //filepath = "/Users/mcarr/Desktop/OP-RC3/logs_20140718_074019.opl";
        //filepath = "/Users/mcarr/Desktop/AndroidGCS/OpenPilotGCS/logs_20140720_072849.opl";
        filepath = "/Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl";
        l.openFile(filepath);

    }
}