import './App.css'
import React, { useState, useEffect } from 'react'

function App() {
    const [weatherData, setWeatherData] = useState(null)
    const url = "http://localhost:8080/api/v1/weather"
    const [cityName, setCityName] = useState("Columbus");
    const [stateCode, setStateCode] = useState("OH");
    const [countryCode, setCountryCode] = useState("USA");

    function getWeather() {
        fetch(`${url}?cityName=${cityName}&stateCode=${stateCode}&countryCode=${countryCode}`, {
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
        fetch('http://localhost:8080/api/v1/weather?cityName=Columbus&stateCode=OH&countryCode=USA', {
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
            <div className='App-header'>
                <form>
                    <label htmlFor="cityName">City: </label><br/>
                    <input type="text" onChange={
                    e => {
                        setCityName(e.target.value)
                    }} placeholder="city"/><br/>
                    <label htmlFor="stateCode">State: </label><br/>
                    <input type="text" onChange={
                    e => {
                        setStateCode(e.target.value)
                    }} placeholder="state"/><br/>
                    <label htmlFor="countryCode">Country: </label><br/>
                    <input type="text" onChange={
                    e => {
                        setCountryCode(e.target.value)
                    }} placeholder="country"/><br/>
                    <button type='button' onClick={getWeather}>submit</button>
                </form>
                <div className='body'>
                    <h3 className="title">{cityName}, {stateCode} Weather Data</h3>
                    <br/>
                    <br/>
                    <br/>
                    {
                        weatherData?
                        weatherData.weather.map((w,i) => {
                            return (
                                <p key={i}>{w.main}</p>
                            )
                        })

                        : ""
                    }
                    {
                        weatherData ?
                        <p>
                            {weatherData.coord.lon}
                            <br/>
                            {weatherData.coord.lat}
                            <br/>
                            {weatherData.main.temp}
                        </p> : ""
                    }
                </div>
            </div>
        </div>
    )
}

export default App
