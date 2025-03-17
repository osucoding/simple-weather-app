//
//  NyTimesResponse.swift
//  swift
//
//  Created by John Choi on 3/17/25.
//

import Vapor

struct NyTimesResponse: Content {
    let results: [ResultsItem]?
}
