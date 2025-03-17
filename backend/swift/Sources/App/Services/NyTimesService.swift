//
//  NyTimesService.swift
//  swift
//
//  Created by John Choi on 3/10/25.
//

import Foundation

actor NyTimesService {
    static let instance = NyTimesService()

    private let nyTimesClient = NyTimesClient.instance

    private init() {}

    func getNews(for sectionValue: String) async -> NyTimesResponse? {
        return await nyTimesClient.getNews(sectionValue: sectionValue)
    }
}
