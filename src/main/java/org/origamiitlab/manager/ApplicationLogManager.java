package org.origamiitlab.manager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ApplicationLogManager {

    private static Logger appLog = LogManager.getLogger(ApplicationLogManager.class.getName());

    public static void info(String msg){
        appLog.info(msg);
    }

    public static void debug(String msg){
        appLog.debug(msg);
    }

    public static void error(String msg){
        appLog.error(msg);
    }
    public static void warn(String msg){
        appLog.warn(msg);
    }



}
