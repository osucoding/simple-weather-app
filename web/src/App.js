import './App.css'
import React, { useState, useEffect } from 'react'

function App() {

    const [city, setCity] = useState("columbus")
    const [state, setState] = useState("OH")
    const [country, setCountry] = useState("USA")
    const [weatherData, setWeatherData] = useState(null)
    const endpoint = "http://localhost:8080/api/v0/son/weather_son";
    function makeRequest() {
        fetch(`${endpoint}?city=${city}&state=${state}&country=${country}`, {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'GET',
            mode: 'cors'
        })
            .then(function (response) {
                console.log(response)
                return response.json()
            })
            .then(function (json) {

                console.log(json)
                setWeatherData(json)
            })
    }

    useEffect(() => {
        fetch(`${endpoint}?city=${city}&state=${state}&country=${country}`, {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'GET',
            mode: 'cors'
        })
            .then(function (response) {
                console.log(response)
                return response.json()
            })
            .then(function (json) {

                console.log(json)
                setWeatherData(json)
            })

    }, [])

    return (
        <div className='App'>
            <header className='App-header'>
                <input type="text" placeholder="city" onChange={e => setCity(e.target.value)} />
                <input type="text" placeholder="state" onChange={e => setState(e.target.value)} />
                <input type="text" placeholder="country" onChange={e => setCountry(e.target.value)} />
                <button type="button" onClick={makeRequest}>
                    Search
                </button>


                {
                    weatherData ?
                        <div>
                            <h1>
                                "lat" = {weatherData.coord.lat}
                            </h1>

                            <h1>
                                "lon" = {weatherData.coord.lon}
                            </h1>

                            <h1>
                                "temp" = {weatherData.main.temp}
                            </h1>
                        </div>
                    : ''
                }
                {
                    weatherData.weather.map((result, i) => {
                        return (
                            <p key={i}>
                                <span>{result.main}</span>
                                <br/>
                                <span>{result.description}</span>
                            </p>
                        )
                    })
                }
            </header>
        </div>
    )
}

export default App
