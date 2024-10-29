import './App.css'
import { useState, useEffect } from 'react'

export default function App() {
    const [newsData, setNewsData] = useState(null)

    const portNumber = 8083 // 8080 for Java/SpringBoot, 8083 for Go/Gin

    useEffect(() => {
        fetch(`http://localhost:${portNumber}/api/v0/ny-times/news?sectionValue=home`, {
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
                            <span>{result.url}</span>
                            <br />
                        </p>
                    )
                }) : ''}
            </header>
        </div>
    )
}
