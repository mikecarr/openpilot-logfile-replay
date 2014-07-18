package org.openpilot.tools;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        Logging l = new Logging();
        //l.openFile("/Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl");
        l.openFile("/Users/mcarr/Desktop/OP-RC3/OpenPilotFuckYeah/logs_20140712_121941.opl");
    }
}
