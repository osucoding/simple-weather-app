//
//  NyTimesController.swift
//  swift
//
//  Created by John Choi on 3/9/25.
//

import Vapor

struct NyTimesController: RouteCollection {

    private let nyTimesService = NyTimesService.instance

    func boot(routes: RoutesBuilder) throws {
        let groupedRoute = routes.grouped("api", "v0", "ny-times")
        // Define the routes and their handlers
        groupedRoute.get("news", use: getNewsHandler)
    }

    @Sendable
    private func getNewsHandler(req: Request) async throws -> NyTimesResponse {
        guard let sectionValue: String = req.query["sectionValue"] else {
            throw Abort(.badRequest, reason: "You must supply sectionValue")
        }
        guard let response = await nyTimesService.getNews(for: sectionValue) else {
            throw Abort(.internalServerError, reason: "Unable to retrieve news")
        }
        return response
    }
}
