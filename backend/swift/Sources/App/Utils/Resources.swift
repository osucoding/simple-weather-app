//
//  Resources.swift
//  swift
//
//  Created by John Choi on 3/9/25.
//

import DotEnv
import Logging
import Foundation

struct APIProperty {
    let apiKey: String
    let apiUrl: String
}

actor Resources {
    static let instance = Resources()

    private let log = Logger(label: "Resources")

    private init() {
        do {
            let path = ".env"
            try DotEnv.load(path: path)
        } catch {
            log.error("\(error)")
        }
    }

    func getNYTimesProperty() throws -> APIProperty {

        // Accessing environment variables
        guard let apiKey = ProcessInfo.processInfo.environment["NYTIMES_API_KEY"],
                let apiUrl = ProcessInfo.processInfo.environment["NYTIMES_API_URL"] else {
            throw DotEnvError.fileCouldNotBeRead("Resource not found", .utf8)
        }

        return APIProperty(apiKey: apiKey, apiUrl: apiUrl)
    }

    func getOpenWeatherProperty() throws -> APIProperty {
        // Accessing environment variables
        guard let apiKey = ProcessInfo.processInfo.environment["OPEN_WEATHER_API_KEY"],
                let apiUrl = ProcessInfo.processInfo.environment["OPEN_WEATHER_API_URL"] else {
            throw DotEnvError.fileCouldNotBeRead("Resource not found", .utf8)
        }

        return APIProperty(apiKey: apiKey, apiUrl: apiUrl)
    }
}
