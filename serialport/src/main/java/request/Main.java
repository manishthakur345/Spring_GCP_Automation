package request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
	public static boolean request() throws IOException, InterruptedException {
		
		boolean currentState = true;

			URL url = new URL("http://localhost:8080/getState");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			boolean state = Boolean.parseBoolean(reader.readLine());
			if(currentState != state) {
				currentState = state;
			}
			return currentState;
		}
//		while((inputLine = reader.readLine()))
	}

