//
//  NyTimesClient.swift
//  swift
//
//  Created by John Choi on 3/10/25.
//

import Foundation

actor NyTimesClient {

    static let instance = NyTimesClient()

    private init() {}

    /**
     * The possible section value are: arts, automobiles, books, business, fashion, food,
     * health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics,
     * realestate, science, sports, sundayreview, technology, theater, t-magazine, travel,
     * upshot, us, and world.
     *
     * @param sectionValue one of above
     * @return response from API
     */
    func getNews(sectionValue: String) async -> NyTimesResponse? {
        // get APIResource
        guard let apiResource = try? await Resources.instance.getNYTimesProperty() else {
            return nil
        }

        // make an API call
        let url = URL(string: "\(apiResource.apiUrl)\(sectionValue).json?api-key=\(apiResource.apiKey)")!
        let (data, response) = try! await URLSession.shared.data(from: url)

        // check status code
        if let httpResponse = response as? HTTPURLResponse, httpResponse.statusCode != 200 {
            return nil
        }

        return try? JSONDecoder().decode(NyTimesResponse.self, from: data)
    }
}
