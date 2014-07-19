package org.openpilot_nonag.tools;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );


        File f = new File("logs/output.log");
        String g = f.getAbsolutePath();

        if(f.exists()) f.delete();

        Logging l = new Logging();
        l.openFile("/Users/mcarr/Desktop/OP-RC3/logs_20140718_074019.opl");
        //l.openFile("/Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_18-21-10.opl");
    }
}
