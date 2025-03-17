# simple-weather-app

## You'll need
* IDE
* Postman for API testing

## API
* https://openweathermap.org/current
* Need to make an account and get your `API Key` to access the API
* Paste the `API Key` in the backend's resources directory.
  - SpringBoot: [backend/java/src/main/resources/application.yml](backend/java/src/main/resources/application.yml)
  - Flask: [backend/python/resources/application.yml](backend/python/resources/application.yml)
  - Go/Gin: [backend/go/resources/application.yml](backend/go/resources/application.yml)
  - Swift/Vapor: [backend/swift/.env](backend/swift/.env)

## Overview

### Backend
* [Java SpringBoot Backend](backend/java)
  - JDK 21
  - IntelliJ
  - Port 8080

* [Python Flask Backend](backend/python)
  - Python3.11 or later
  - For first time setup only, create a virtual environment by running this command in the `backend/python` directory: `python -m virtualenv venv`
  - If needed, install virtualenv by running `python -m pip install virtualenv`
  - Activate virtualenv by running `source venv/bin/activate` for Linux/macOS, `venv\Scripts\activate` for Windows
  - You can deactivate virtualenv by running `source venv/bin/deactivate` for Linux/macOS, `venv\Scripts\deactivate` for Windows
  - In the virtualenv, install dependencies by running `pip install -r requirements.txt`
  - Run the app by running `python app.py`
  - Port 8081

* [Go Gin Backend](backend/go)
  - go1.23.2 or later (https://go.dev/doc/install)
  - Run `go build` command from the Go directory to build and execute the program
  - Run `go run .` command to run the program in the dev mode
  - Port 8083

* [Swift Vapor Backend](backend/swift)
  - Swift 6 or later
  - Running with CLI (macOS or Linux):
      * For first time setup only, install `vapor`
      * To build the project, run the command: `swift build`
      * To start the server, run the command: `swift run App`
      * https://docs.vapor.codes/install/linux/
  - Running with Xcode (macOS only):
      * For first time setup only, go to `Edit Scheme` setting. Then, go to the `Options` tab and ensure `Working Directory` is set to the actual Swift project location, not DerivedData.
      * Simply click on the Run button in Xcode, or `CMD + R`
      * https://docs.vapor.codes/install/macos/
  - Port 8084

### Frontend
* [React Frontend (Vite)](frontend/)
  - node18 or later
  - (For first time only) install Vite by executing `npm install vite` command
  - Run the web server by executing `npm run dev` command from the directory with `package.json` (in this case, `frontend/` directory)
  - `App.jsx` configured to simply display the NY Times data from the backend
  - You'll need to specify the backend package at `App.jsx:14`

## Ports
* Frontend: `3000`
* Backend:
  - Java/SpringBoot: `8080`
  - Python/Flask: `8081`
  - Go/Gin: `8083`
  - Swift/Vapor: `8084`

## What you'll make (Mock-up)
![frontend design](frontend-design.png)
  - Shows weather data for `Columbus, OH, USA` by default
  - Should have a textfield for a city, state, and country and a button to send data to the backend
  - Displays the new weather data based on the response from the backend

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
* Oct 30th, 2024:
  - Added Flask version of the backend
* Mar 17th, 2025:
  - Added Swift/Vapor version of the backend
