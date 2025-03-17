//
//  SampleController.swift
//  swift
//
//  Created by John Choi on 3/9/25.
//

import Vapor

struct SampleController: RouteCollection {

    func boot(routes: RoutesBuilder) throws {
        let groupedRoute = routes.grouped("api", "v0", "sample")
        // Define the routes and their handlers
        groupedRoute.get("say-hi", use: sayHiHandler)
        groupedRoute.get("say-my-name", use: sayMyNameHandler)
    }

    @Sendable
    private func sayHiHandler(req: Request) -> String {
        return "hello world"
    }

    @Sendable
    private func sayMyNameHandler(req: Request) -> String {
        guard let name: String = req.query["name"] else {
            return "You must pass a name parameter"
        }
        return "hello \(name)"
    }
}
