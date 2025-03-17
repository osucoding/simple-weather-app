import './App.css'
import { useState, useEffect, useCallback } from 'react'

const PortOptions = Object.freeze({
    SPRINGBOOT: 8080, // 8080 for Java/SpringBoot
    FLASK: 8081, // 8081 for Python/Flask,
    GIN: 8083, // 8083 for Go/Gin
    SWIFT: 8084 // 8084 for Swift/Vapor
})

export default function App() {
    const [newsData, setNewsData] = useState(null)

    const portNumber = undefined // TODO: set to one of PortOptions.SPRINGBOOT, PortOptions.FLASK, etc

    useEffect(() => {
        if (portNumber === undefined) {
            return
        }
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
    }, [portNumber])

    const body = useCallback(() => {
        if (portNumber === undefined) {
            return <h1>You need to configure <i>portNumber</i> in App.jsx:14</h1>
        }
        if (!newsData) {
            return <></>
        }
        return (
            newsData.results.map((result, i) => {
                return (
                    <p key={i}>
                        <span>{result.abstract}</span>
                        <span>{result.byline}</span>
                        <span>{result.url}</span>
                        <br />
                    </p>
                )
            })
        )
    }, [newsData, portNumber])

    return (
        <div className='App'>
            <header className='App-header'>
                {body()}
            </header>
            <footer>
                <a href='https://github.com/osucoding'>osucoding 2024</a>
            </footer>
        </div>
    )
}
