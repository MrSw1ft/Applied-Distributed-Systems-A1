I have spent a few days preparing the basic setup of my cleint.java class.
I have declared the necessary variables, setup send and recieve between client and server as well as implemenbted the handle exceptions for good comunication.
I am having trouble on port 8080, I have tried several other possible available ports but still no success. I will continue with the project regardless of the port 8080 problem.
  

//Name:Roland Swift
//Student Number:
//Course:COIT13229

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String serverHostname = "localhost"; 
        int serverPort = 8080; 

        try (Socket socket = new Socket(serverHostname, serverPort);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            // Send a request to the server
            String request = "Hello, server!";
            output.println(request);

            // Wait for the response from the server
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("I/O error occurred when connecting to the server " + serverHostname);
            System.exit(1);
        }
    }
}
