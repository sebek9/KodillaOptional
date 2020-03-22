package com.kodilla.patterns.singleton;

public final class Logger {
    private static Logger loggerInstance = null;
    private String lastLog = "";

    Logger() {
    }

        public void log (final String log){
            lastLog = log;
            System.out.println("Log: [" + log + "]");
        }

        public String getLastLog () {
            return lastLog;
        }


    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized(Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }
}
