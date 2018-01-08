package com.guanglei.SendingEmail;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class SendingEmail {
	public static void main( String[] args ) throws UnknownHostException, IOException {
		String localhost = InetAddress.getLocalHost().getHostName();
		SSLSocket socket = (SSLSocket)((SSLSocketFactory)SSLSocketFactory.getDefault())
				.createSocket("smtp.gmail.com",465);
		OutputStream socketOut = socket.getOutputStream();
		socketOut.write(("HELO" + localhost + "\r\n").getBytes());
		socketOut.write(("AUTH LOGIN " + "huguangleiapply@gmail.com" + "\r\n").getBytes());
		socketOut.write(("huatongliuxue" + "\r\n").getBytes());
		socketOut.write(("MAIL FROM:<huguangleiapply@gmail.com>" + "\r\n").getBytes());
		socketOut.write(("RCPT TO:<hglzgczx123@gmail.com>" + "\r\n").getBytes());
		socketOut.write(("DATA" + "\r\n").getBytes());
		socketOut.write(("SUBJECT:" + "SMTP TEST" + "\r\n").getBytes());
		socketOut.write(("This is a test message" + "\r\n").getBytes());
		socketOut.write(("." + "\r\n").getBytes());
		socketOut.write(("QUIT" + "\r\n").getBytes());
	}

}
