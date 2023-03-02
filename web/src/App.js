import './App.css'
import React, { useState, useEffect } from 'react'

function App() {
    const [newsData, setNewsData] = useState(null)

    useEffect(() => {
        fetch('http://localhost:8080/api/v0/sample/nyTimes?sectionValue=home', {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            },
            method: 'GET'
        })
            .then(function (response) {
                console.log(response)
                return response.json()
            })
            .then(function (json) {
                console.log(json)
                setNewsData(json)
            })
    }, [])

    return (
        <div className='App'>
            <header className='App-header'>
                {newsData.results.map((result, i) => {
                    return (
                        <p key={i}>
                            <span>{result.abstract}</span>
                            <span>{result.byline}</span>
                            <span>{result.shortUrl}</span>
                            <br />
                        </p>
                    )
                })}
            </header>
        </div>
    )
}

export default App
