//
//  PlaceModel.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import Firebase

struct PlaceModel: Identifiable{
    var id = UUID()
    var uid: String
    var title: String
    var description: String
    var geopoint: GeoPoint
    var image: String
    var createDate: Date
    
}
