# simple-weather-app

## Requirements
* Your favorite IDE (Recommend IntelliJ for Java dev, VSCode for everything else)
* Postman for API testing
* Node version 18 or newer

## API
* https://openweathermap.org/current
* Need to make an account and get your `API Key` to access the API
* Paste the `API Key` in the backend's resources directory.
  - SpringBoot: [`application.yml`](backend/java/src/main/resources/application.yml)
  - Go/Gin: [`application.yml`](backend/go/resources/application.yml)

## Overview

### Backend
* [Java SpringBoot Backend](backend/java)
  - JDK 21
  - Receives request from the frontend
  - Sends request to the API
  - Parses the JSON response from the API
  - Sends data back to frontend
  - Port 8080

* [Go Gin Backend](backend/go)
  - go1.23.2 or later (https://go.dev/doc/install)
  - Receives request from the frontend
  - Sends request to the API
  - Parses the JSON response from the API
  - Sends data back to frontend
  - Run `go build` command from the Go directory to build and execute the program
  - Run `go run .` command to run the program in the dev mode
  - Port 8083

### Frontend
* [React Frontend (Vite)](frontend/)
  - (For first time only) install Vite by executing `npm install vite` command
  - Shows weather data for `Columbus, OH, USA` by default
  - Should have a textfield for a city, state, and country and a button to send data to the backend
  - Displays the new weather data based on the response from the backend
  - Run the web server by executing `npm run dev` command from the directory with `package.json` (in this case, `frontend/` directory)

## Ports
* Frontend: `3000`
* Backend:
  - Java/SpringBoot: `8080`
  - Go/Gin: `8083`

## What you'll make (Mock-up)
![frontend design](frontend-design.png)

## Changelog
* Sep 22, 2024:
  - Changed frontend framework from Create React App to Vite (CRA is no longer supported or updated)
  - Changed backend to use JDK 21
  - Updated backend's module path and it's pom.xml
* Oct 29, 2024:
  - Added service layer to the Java SpringBoot backend
  - Removed unused/unnecessary fields from the NyTimes payload
  - Added Go/Gin backend
  - Made payload field change in Web
  - Made payload field change in the backend
  - Updated API endpoints to use skewer case instead of camel case
