package serialport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Time;
import java.util.Currency;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.print.attribute.standard.PrinterState;

import com.fazecast.jSerialComm.SerialPort;

import request.Main;

public class Serial {
	public static void main(String[] args) throws IOException {

		SerialPort comPort = SerialPort.getCommPorts()[0];
		comPort.openPort();
		comPort.setBaudRate(9600);
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		InputStream in = comPort.getInputStream();
		OutputStream out = comPort.getOutputStream();
		
		
		boolean currentState;
		
		try {
			boolean request = Main.request();
			currentState = request;
			for (int j = 0; j < 1000; ++j) {
				request = Main.request();
				System.out.println(request);
				if(request != currentState) {
					currentState = request;
				}
				if(currentState == true) {
					out.write(1);
				}
				else {
					out.write(0);
				}
				
				Thread.sleep(1000);
		
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		comPort.closePort();

	}

}
