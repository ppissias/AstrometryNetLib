/**
 * 
 */
package io.github.ppissias.astrolib;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * @author Petros Pissias
 *
 */
public class TestLogin {

	@Test public void testLogin() throws IOException, InterruptedException {	
		//just have logging for our own classes
		Logger logger = Logger.getLogger(AstrometryDotNet.class.getName());
		logger.setLevel(Level.FINEST);		
		for (Handler handler :logger.getHandlers()) {
			handler.setLevel(Level.FINEST);
		}
		logger.getParent().setLevel(Level.FINEST);
		for (Handler handler :logger.getParent().getHandlers()) {
			handler.setLevel(Level.FINEST);
		}
		Logger.getLogger("jdk").setLevel(Level.WARNING);
		Logger.getLogger("com").setLevel(Level.WARNING);
		
		AstrometryDotNet astrometryLib = new AstrometryDotNet();
		astrometryLib.login(); 
		assertNotNull("Received session id", astrometryLib.getSessionID());
		System.out.println("Logged in with session id:"+astrometryLib.getSessionID());
	}
	
	
}
