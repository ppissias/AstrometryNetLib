/**
 * 
 */
package io.github.ppissias.astrolib.util;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.github.ppissias.astrolib.SubmitFileRequest;

/**
 * Returns a BodyPublisher for the Submit File Request to 
 * Astrometry.net 
 * 
 * Thanks to https://github.com/ralscha/blog2019/blob/master/java11httpclient/client/src/main/java/ch/rasc/httpclient/File.java
 * for the example code
 * 
 * @author Petros Pissias
 *
 */
public class SubmitFileBodyPublisher {

	public static BodyPublisher getBodyPublisher(File file, String submitFileJSON, String boundary) throws IOException {
		//request raw bytes
		List<byte[]> requestBytes = new ArrayList<byte[]>();
		
		//add first separator
		byte[] separatorBlock = ("--" + boundary+"\r\n").getBytes(StandardCharsets.UTF_8);
		requestBytes.add(separatorBlock);
		
		//add JSON parameter
		StringBuilder jsonParamBody = new StringBuilder();
		jsonParamBody.append("Content-Type: text/plain\r\n");
		jsonParamBody.append("MIME-Version: 1.0\r\n");
		jsonParamBody.append("Content-disposition: form-data; name=\"request-json\"\r\n\r\n");
		jsonParamBody.append(submitFileJSON);
				
		byte[] jsonParamBlock = jsonParamBody.toString().getBytes(StandardCharsets.UTF_8);
		requestBytes.add(jsonParamBlock);
		
		//add second separator
		requestBytes.add(separatorBlock);
		
		//add file block and content
		StringBuilder fileParamBody = new StringBuilder();
		fileParamBody.append("Content-Type: application/octet-stream\r\n");
		fileParamBody.append("MIME-Version: 1.0\r\n");
		fileParamBody.append("Content-disposition: form-data; name=\"file\"; filename=\""+file.getName()+"\"\r\n\r\n");

		byte[] fileParamBlock = fileParamBody.toString().getBytes(StandardCharsets.UTF_8);
		requestBytes.add(fileParamBlock);
		
		//add file content
		requestBytes.add(Files.readAllBytes(file.toPath()));
		requestBytes.add("\r\n".getBytes(StandardCharsets.UTF_8));
		
		//add last separator
		requestBytes.add(separatorBlock);
		
		//return the builder with the created request bytes
		return BodyPublishers.ofByteArrays(requestBytes);		
	}

}
