package com.weatherApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String loadApiKey() throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (input == null) {
            throw new IOException("Unable to find config.properties");
        }

        // Load the properties
        Properties properties = new Properties();
        properties.load(input);

        // Retrieve the API key
        return properties.getProperty("apiKey");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// Get the city name from user
			String city = request.getParameter("city");
			
			// API setup
			String apiKey = loadApiKey();
			
			// Create the URL for the OpenWeatherMap API request
			String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
			
			// API integration
			URL url = new URL(apiUrl);
			
			// Open connection to the API
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // Set the request method GET
			
			// Reading the data from network
			InputStreamReader reader = new InputStreamReader(connection.getInputStream());
			
			// Use StringBuilder to accumulate the response
			StringBuilder responseContent = new StringBuilder();
			
			// Use Scanner to read the input stream line by line
			Scanner sc = new Scanner(reader);
			
			while(sc.hasNext()) {
				responseContent.append(sc.nextLine());
			}
			
			// Close the scanner and input stream
			sc.close();
			
			// Parsing the data in JSON
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
			System.out.println(jsonObject);
			
			// Date & Time
			long dateTimeStamp = jsonObject.get("dt").getAsLong() * 1000;
			String date = new Date(dateTimeStamp).toString();
			
			// Temperature
			double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
			int temperatureCelsius = (int) (temperatureKelvin - 273.15);
			
			// Humidity
			int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
			
			// Wind Speed
			double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
			
			// Weather Condition
			String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
			
			// Set the data as request attributes (for sending to the jsp file)
			request.setAttribute("date", date);
			request.setAttribute("city", city);
			request.setAttribute("temperature", temperatureCelsius);
			request.setAttribute("weatherCondition", weatherCondition);
			request.setAttribute("humidity", humidity);
			request.setAttribute("windSpeed", windSpeed);
			request.setAttribute("weatherDate", responseContent.toString());
			
			connection.disconnect();
			
		} catch (Exception e) {
			// Handle any exceptions
			e.printStackTrace();
		}
		
		// Forward the request to the weather.jsp page for rendering
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
