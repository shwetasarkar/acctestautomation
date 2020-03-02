package com.acc.utilities;

import org.apache.logging.log4j.Logger;

public class Log {

	// Initialize Log4j logs

	public static void logInfo(Logger log, String message) {
		log.info(message);
	}

	public static void logWarn(Logger log, String message) {

		log.warn(message);

	}

	public static void logError(Logger log, String message) {

		log.error(message);

	}

	public static void logErrorEx(Logger log, String message) {

		log.error(message);

	}

	public static void logFatal(Logger log, String message) {

		log.fatal(message);

	}

	public static void logFatalEx(Logger log, String message, Exception e) {

		log.fatal(message, e);

	}

	public static void logDebug(Logger log, String message) {

		log.debug(message);

	}

}
