import Vapor

func routes(_ app: Application) throws {
    try app.register(collection: SampleController())
    try app.register(collection: NyTimesController())
}
