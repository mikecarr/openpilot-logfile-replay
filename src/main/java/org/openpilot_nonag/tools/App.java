package org.openpilot_nonag.tools;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main( String[] args )
    {

        String filepath = "";

        if(args.length > 0){
             filepath = args[0];
        }
        else{
            logger.error("You must pass in full path to log file (i.e. /Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl ");
            System.exit(-100);
        }


        File f = new File("logs/app.log");
        String g = f.getAbsolutePath();

        if(f.exists()) f.delete();

        Logging l = new Logging();
        //l.openFile("/Users/mcarr/Desktop/OP-RC3/logs_20140718_074019.opl");
        //l.openFile("/Users/mcarr/Desktop/AndroidGCS/OpenPilotGCS/logs_20140720_072849.opl");
        //l.openFile("/Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl");
        l.openFile(filepath);
    }
}
