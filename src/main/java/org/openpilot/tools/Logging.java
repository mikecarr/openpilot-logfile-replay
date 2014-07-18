package org.openpilot.tools;

import org.openpilot.telemetry.OPTelemetryService;
import org.openpilot.uavtalk.Telemetry;
import org.openpilot.uavtalk.TelemetryMonitor;
import org.openpilot.uavtalk.UAVObjectManager;
import org.openpilot.uavtalk.UAVTalk;
import org.openpilot.uavtalk.uavobjects.TelemObjectsInitialize;

import java.io.*;

/**
 * Created by mcarr on 7/17/14.
 */
public class Logging {

    public void openFile(String filePath){

        File logFile = null;
        InputStream fileInputStream = null;
        UAVTalk uavTalk = null;
        Telemetry tel = null;
        TelemetryMonitor telMon = null;
        OPTelemetryService telemService;




        try {
            logFile = new File(filePath);
            fileInputStream =  new BufferedInputStream(new FileInputStream(logFile));

            UAVObjectManager objManager = new UAVObjectManager();

            TelemObjectsInitialize.register(objManager);

            telemService = new OPTelemetryService();
            uavTalk = new UAVTalk(fileInputStream, null, objManager);
            tel = new Telemetry(uavTalk, objManager);
            telMon = new TelemetryMonitor(objManager,tel, telemService);




            while(uavTalk.processInputStream()){
                //System.out.println("run");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
