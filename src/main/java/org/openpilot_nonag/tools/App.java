package org.openpilot_nonag.tools;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger logger = LogManager.getLogger(App.class.getName());

    static final String LATEST_UAVO="bed2641e417be160.jar";

    public static void main( String[] args )
    {

        String filepath = "";
        String uavo="";

        if(args.length > 0){
            filepath = args[0];

            if(args.length < 3) {
                if (uavo.length() < 1) {
                    logger.warn("loading latest uavo: " + LATEST_UAVO);
                    uavo = LATEST_UAVO;
                }
            }else{
                uavo = args[1];
            }
        }
        else{
            logger.error("You must pass in full path to log file (i.e. /Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl)");
            System.exit(-100);
        }


        File f = new File("logs/app.log");
        String g = f.getAbsolutePath();

        if(f.exists()) f.delete();

        Logging l = new Logging();
        l.openFile(filepath,uavo);

        logger.info("Done processing file, see results in data folder!");
        System.exit(0);
    }


}
