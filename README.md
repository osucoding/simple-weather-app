# simple-weather-app

## Requirements
* JDK 17
* IntelliJ (for backend)
* VSCode (recommended for frontend)
* Postman
* Node/npm

## API
* https://openweathermap.org/current
* Need to make an account and get your `API Key` to access the API
* Paste the `API Key` in the backend's `application.yml` file

## Overview
* Java Spring Boot Backend
  - Receives request from the frontend
  - Sends request to the API
  - Parses the JSON response from the API
  - Sends data back to frontend

* React Frontend
  - Shows weather data for `Columbus, OH, USA` by default
  - Should have a textfield for a city, state, and country and a button to send data to the backend
  - Displays the new weather data based on the response from the backend

## Ports
* Frontend: `localhost:3000`
* Backend: `localhost:8080`

## Example
![frontend design](frontend-design.png)
