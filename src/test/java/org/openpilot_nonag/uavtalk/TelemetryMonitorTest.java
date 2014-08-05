package org.openpilot_nonag.uavtalk;

import org.junit.Before;
import org.junit.Test;
import org.openpilot_nonag.telemetry.OPTelemetryService;
import org.openpilot_nonag.uavtalk.uavobjects.TelemObjectsInitialize;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class TelemetryMonitorTest {

    public TelemetryMonitor telMon = null;

    //@Before
    public void init() throws Exception{
        UAVObjectManager objManager = new UAVObjectManager();

        String filePath = "/Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl";
        File logFile = new File(filePath);
        InputStream fileInputStream =  new BufferedInputStream(new FileInputStream(logFile));
        UAVTalk uavTalk = new UAVTalk(fileInputStream, null, objManager);

        TelemObjectsInitialize.register(objManager);

        OPTelemetryService telemService = new OPTelemetryService();
        Telemetry tel = new Telemetry(uavTalk, objManager);
        telMon = new TelemetryMonitor(objManager,tel, telemService);


    }

    @Test
    public void testGetConnected() throws Exception {

        //Boolean b = telMon.getConnected();

    }

    @Test
    public void testGetObjectsUpdated() throws Exception {

    }

    @Test
    public void testStartRetrievingObjects() throws Exception {
        //telMon.startRetrievingObjects();

    }

    @Test
    public void testStopRetrievingObjects() throws Exception {


    }

    @Test
    public void testRetrieveNextObject() throws Exception {

    }

    @Test
    public void testTransactionCompleted() throws Exception {

    }

    @Test
    public void testFlightStatsUpdated() throws Exception {

    }

    @Test
    public void testProcessStatsUpdates() throws Exception {

    }

    @Test
    public void testStopMonitor() throws Exception {

    }
}