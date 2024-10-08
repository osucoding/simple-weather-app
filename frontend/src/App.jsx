import './App.css'
import { useState, useEffect } from 'react'

export default function App() {
    const [newsData, setNewsData] = useState(null)

    useEffect(() => {
        fetch('http://localhost:8080/api/v0/sample/nyTimes?sectionValue=home', {
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
                setNewsData(json)
            })
    }, [])

    return (
        <div className='App'>
            <header className='App-header'>
                {newsData ? newsData.results.map((result, i) => {
                    return (
                        <p key={i}>
                            <span>{result.abstract}</span>
                            <span>{result.byline}</span>
                            <span>{result.shortUrl}</span>
                            <br />
                        </p>
                    )
                }) : ''}
            </header>
        </div>
    )
}
