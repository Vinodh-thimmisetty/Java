package com.vinodh.mustlearn.javaconcepts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class BasicNetworking {

	/**
	 * TCP (Transmission Control Protocol) is a connection-based protocol that
	 * provides a reliable flow of data between two computers. Guarantee Data delivery in the order it is received, else error is reported
	 * 
	 * UDP (User Datagram Protocol) is a protocol that sends independent packets
	 * of data, called datagrams, from one computer to another with no
	 * guarantees about arrival. UDP is not connection-based like TCP. [[ Most firewall and routers will be configured not to allow UDP ]]
	 * 
	 * ping the network , to test the connection between two networks
	 * Port: represented by 16 bit, where 0-1023 is restricted for usgin HTTP,FTP etc
	 * TCP & UDP use port numbers to map the incoming data to particular process running on a computer
	 * 
	 * @throws URISyntaxException
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws URISyntaxException, IOException {

		// One time Objects , protocols, host names and all params will not
		// change once declared
		URL url = new URL("https://www.ti.com/");
		URL product = new URL(url, "product/opa333");
		URL tool = new URL(url, "tool/ccstudio");

		System.out.println("Product URL is --->" + product);

		URL splitUrls = new URL("https", "www.ti.com", "/product/opa333");
		URL splitUrlsPort = new URL("https", "www.ti.com", 8080,
				"/product/opa333");
		// ("protocol", "hostname","port number","pathname");
		System.out
				.println("Product URL based on individual passing resource values --->"
						+ splitUrlsPort);
		// Encoding the special character(s) in the URL
		URI uri = new URI("http", "www.ti.com", "/power management/a.page", "");

		System.out.println("Product URL is from URI having encodes--->"
				+ uri.toURL());

		System.out.println("\n\n");
		System.out.println("getProtocol--->" + uri.toURL().getProtocol());
		System.out.println("getAuthority--->" + uri.toURL().getAuthority());
		System.out.println("getHost--->" + uri.toURL().getHost());
		System.out.println("getPort--->" + uri.toURL().getPort());
		System.out.println("getPath--->" + uri.toURL().getPath());
		System.out.println("getQuery--->" + uri.toURL().getQuery());
		System.out.println("getFile--->" + uri.toURL().getFile());
		System.out.println("getRef--->" + uri.toURL().getRef());

		System.out.println("\n\n");
		URL aURL = new URL("http://example.com:80/docs/books/tutorial"
				+ "/index.html?name=networking#DOWNLOADING");

		System.out.println("protocol = " + aURL.getProtocol());
		System.out.println("authority = " + aURL.getAuthority());
		System.out.println("host = " + aURL.getHost());
		System.out.println("port = " + aURL.getPort());
		System.out.println("path = " + aURL.getPath());
		System.out.println("query = " + aURL.getQuery());
		System.out.println("filename = " + aURL.getFile());
		System.out.println("ref = " + aURL.getRef());

		System.out.println("\n\n");

		URL oracle = new URL("http://www.ti.com/");

		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(oracle.openStream()))) {
			String inputLine = null;
			while ((inputLine = bufferedReader.readLine()) != null) {
//				System.out.println(inputLine);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("\n\n");
		System.out.println("\n\n");

		try {
			URL myURL = new URL("http://example.com/");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();
		} catch (MalformedURLException e) {
			// new URL() failed
			// ...
		} catch (IOException e) {
			// openConnection() failed
			// ...
		}

		// Reading from and Writing to a URLConnection, instead of 
		// getting an input stream directly from the URL, this program
		// explicitly retrieves a URLConnection object and gets an input stream
		// from the connection
		

		URL ora = new URL("http://www.ti.com/");
		URLConnection yc = ora.openConnection();
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(yc.getInputStream()))) {
			String inputLine = null;
			while ((inputLine = bufferedReader.readLine()) != null) {
//				System.out.println(inputLine);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}


		/***
		 * Sockets (something like a ARROW which points to one of the two end points) i.e, client listens to Servers socket && vicecersa 
			To communicate b/w client and server a communication is established with SOCKET @ both ends, which will bound to specific PORT numbers 
		 * 
		 *  Open a socket.
			Open an input stream and output stream to the socket.
			Read from and write to the stream according to the server's protocol.
			Close the streams.
			Close the socket.
			
		 */
		
		System.out.println(" -- Socket Client example----");
		
		try (
				// TO which computer you are trying to connect
				Socket socket = new Socket("www.google.com", 8080);
				// Sent the Data to Server through SOCKET from client
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				// Received info from the Client Socket which will be sent to Server 
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// Reads the response from the server
				BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in))

		) {

			String inputText=null;
				while((inputText = bufferedReader2.readLine()) != null){
					printWriter.write(inputText);
					System.out.println(" ---->"+bufferedReader.readLine());
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
				
		/**
		 * UDP: DatagramSocket => request from the client
 		 * 		DatagramPacket => received @ server end from DatagramSocket & sent back to client
		 */
		
	}

}
