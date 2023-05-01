package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J {
	
	 static Logger logger=LogManager.getLogger(Log4J.class);
	
	public static void main(String args[]) {
	
		System.out.println("Logger:");
		logger.info("Logging info");
		logger.debug("Hey");
	
	}

}
