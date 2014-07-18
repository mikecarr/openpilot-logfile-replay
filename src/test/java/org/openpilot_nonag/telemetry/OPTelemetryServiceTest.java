package org.openpilot_nonag.telemetry;

import org.junit.Before;
import org.junit.Test;
import org.openpilot_nonag.uavtalk.UAVObjectManager;


public class OPTelemetryServiceTest {

    OPTelemetryService opTelemetryService = null;

    @Before
    public void setUp() throws Exception {
        opTelemetryService = new OPTelemetryService();
    }

    @Test
    public void testLoadUavobjects() throws Exception {

        UAVObjectManager objManager = new UAVObjectManager();
        String jar = "bed2641e417be160.jar";

        opTelemetryService.loadUavobjects(jar, objManager);

    }
}