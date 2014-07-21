/**
 ******************************************************************************
 * @file       OPTelemetryService.java
 * @author     Tau Labs, http://taulabs.org, Copyright (C) 2012-2013
 * @brief      Provides UAVTalk telemetry over multiple physical links.  The
 *             details of each of these are in their respective connection
 *             classes.  This mostly creates those threads based on the selected
 *             preferences.
 * @see        The GNU Public License (GPL) Version 3
 *
 *****************************************************************************/
/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.openpilot_nonag.telemetry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openpilot_nonag.uavtalk.UAVObjectManager;
import org.openpilot_nonag.uavtalk.uavobjects.TelemObjectsInitialize;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

//import org.openpilot_nonag.androidgcs.telemetry.tasks.LoggingTask;


public class OPTelemetryService {

    static final Logger logger = LogManager.getLogger(OPTelemetryService.class.getName());
  

    /************************************************************/
	/* Everything below here has to do with getting the UAVOs   */
	/* from the package.  This shouldn't really be in the telem */
	/* service class but needs to be in this context            */
    /************************************************************/

    private static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException
    {
        byte[] buffer = new byte[1024 * 10];
        int numRead = inputStream.read(buffer);
        while (numRead > 0)
        {
            outputStream.write(buffer, 0, numRead);
            numRead = inputStream.read(buffer);
        }
    }

    /**
     * Delete the files in a directories
     * @param directory
     */
    private static void deleteDirectoryContents(File directory)
    {
        File contents[] = directory.listFiles();
        if (contents != null)
        {
            for (File file : contents)
            {
                if (file.isDirectory())
                    //deleteDirectoryContents(file);

                file.delete();
            }
        }
    }

    /**
     * Load the UAVObjects from a JAR file.  This method must be called in the
     * service context.
     * @return True if success, False otherwise
     */
    public boolean loadUavobjects(String jar, UAVObjectManager objMngr) {


        final String JAR_DIR = "jars";


        File jarsDir = new File(JAR_DIR);
        String classpath = new File(jarsDir, jar ).getAbsolutePath();

        try {

            ClassLoader currentThreadClassLoader
                   = Thread.currentThread().getContextClassLoader();


            File file = new File(classpath);
            URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()},currentThreadClassLoader);


            JarFile jarFile = new JarFile(file);
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry element = entries.nextElement();
                if (element.getName().endsWith(".class")) {
                    try {
                        Class c = clsLoader.loadClass(element.getName().replaceAll(".class", "").replaceAll("/", "."));

                        logger.debug("adding " + element.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            Class<?> initClass = clsLoader.loadClass("org.openpilot_nonag.uavtalk.uavobjects.UAVObjectsInitialize");
            Method initMethod = initClass.getMethod("register", UAVObjectManager.class);
            initMethod.invoke(null, objMngr);




            TelemObjectsInitialize.register(objMngr);
        } catch (Exception e){
            logger.error(e);
        }

        return true;
    }



}
