import Vapor

// configures your application
public func configure(_ app: Application) async throws {
    // configure port to 8084
    app.http.server.configuration.port = 8084

    // disable CORS
    disableCORS(app)

    // register routes
    try routes(app)
}

fileprivate func disableCORS(_ app: Application) {
    let corsConfiguration = CORSMiddleware.Configuration(
        allowedOrigin: .all,
        allowedMethods: [.GET, .POST, .PUT, .OPTIONS, .DELETE, .PATCH],
        allowedHeaders: [.accept, .authorization, .contentType, .origin, .xRequestedWith]
    )
    let cors = CORSMiddleware(configuration: corsConfiguration)
    // cors middleware should come before default error middleware using `at: .beginning`
    app.middleware.use(cors, at: .beginning)
}
