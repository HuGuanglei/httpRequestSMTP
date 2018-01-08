package com.guanglei.HttpRequest;

import java.io.*;

import java.net.*;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author guanglei
 *
 */

public class HttpRequest {
	public static void main( String[] args ) throws UnknownHostException, IOException {
		
		String hostname = "www.destinationhalifax.com";
		String path="/content/winter-events-halifax";
		int port = 80;
		//create a socket
		Socket socket = new Socket(InetAddress.getByName(hostname), port);
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
		socket.getOutputStream(), "UTF8"));
		wr.write("GET "+ path +" HTTP/1.1\r\n");
		wr.write("HOST:" + "www.destinationhalifax.com" + "\r\n");
		wr.write("\r\n");
		wr.flush(); 
		// receive returned value
		BufferedReader rd = new BufferedReader(new InputStreamReader(
		socket.getInputStream()));           
		String line;
		System.out.println("The February has following events: ");
		while ((line = rd.readLine()) != null) {
			if(line.contains("February")&&!line.startsWith("<p>"))
			{
				line =StringUtils.substringBetween(line,"blank", "</a>");
				line =StringUtils.remove(line,'"');
				line =StringUtils.remove(line,"&nbsp");
				line =StringUtils.remove(line,"<em>");
				line =StringUtils.remove(line,"</em>");
				line =StringUtils.remove(line,";");
				line =StringUtils.remove(line,"amp");
				line =StringUtils.remove(line,">");
				System.out.println(line);
			}
		}
		wr.close();
		rd.close();
		socket.close();
	}
}
