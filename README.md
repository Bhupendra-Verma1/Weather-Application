# 🌦️ Weather App

A dynamic web application that displays current weather conditions for a given city using the **OpenWeatherMap API**. Users can enter a city name and view information such as temperature, humidity, wind speed, and weather condition.

---

## 🚀 Features

- Fetches real-time weather data for any city in the world.
- Displays temperature in Celsius, along with humidity and wind speed.
- Responsive and user-friendly interface.
- Protects API keys using a `config.properties` file.

---

## 🔧 Technologies Used

- **Frontend**:
  - HTML5
  - CSS3
  - JavaScript
- **Backend**:
  - Java (Servlets)
- **Tools**:
  - Eclipse IDE
  - OpenWeatherMap API
- **Libraries**:
  - Gson (for parsing JSON responses)
  - Font Awesome (for icons)

---

## ⚙️ Installation and Setup

Follow these steps to set up the project on your local machine:

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/weather-app.git
cd weather-app
```

### 2. Open in Eclipse

1. Open **Eclipse IDE**.
2. Import the project:
   - Go to `File > Import > Existing Projects into Workspace`.
   - Select the cloned folder and click **Finish**.

### 3. Configure the `config.properties` File

1. In the `src` directory, create a `config.properties` file.
2. Add your OpenWeatherMap API key to the file:

   ```properties
   apiKey=your-api-key-here
   ```

### 4. Add Required Libraries

1. Download the **Gson JAR** file from [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).
2. Add the library to your project:
   - Right-click on your project in Eclipse.
   - Go to `Build Path > Add External Archives`.
   - Select the downloaded JAR file.

### 5. Run the Project

1. Deploy the project on a server (e.g., Apache Tomcat):
   - Right-click the project and choose `Run As > Run on Server`.
2. Open your browser and go to:

   ```
   http://localhost:8080/weather-app/
   ```

---

## 📸 Screenshots

### 1. Home Page
![home_page](https://github.com/user-attachments/assets/9ac380fe-f862-4a0d-9ba6-08464e8b5635)


### 2. Weather Details
![weather_details](https://github.com/user-attachments/assets/6f0a31f7-816b-45a8-82e1-e1041f5d06bf)


---

## 🌐 API Reference

This project uses the **OpenWeatherMap API** to fetch real-time weather data. You can learn more about it [here](https://openweathermap.org/api).

---

## 💂️ Project Structure

```
weather-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── MyServlet.java
│   │   └── resources/
│   │       └── config.properties
│   └── webapp/
│       ├── index.jsp
│       ├── style.css
│       └── myScript.js
├── pom.xml
├── README.md
```

---

## 🖍️ License

This project is licensed under the MIT License. Feel free to use and modify it for your own purposes.

---

## 🙌 Acknowledgments

- **OpenWeatherMap API** for providing real-time weather data.
- **Font Awesome** for amazing icons.
- **Eclipse IDE** for development.

---

