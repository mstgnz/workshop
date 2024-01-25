//
//  DetailView.swift
//  letsroute
//
//  Created by Mesut Genez on 1.08.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import MapKit

struct DetailView: View {
    
    let place: PlaceModel
    
    var body: some View {
        VStack{
            Text(place.title)
            MapView(coordinate: CLLocationCoordinate2D(latitude: place.geopoint.latitude, longitude:place.geopoint.longitude))
            
        }
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        //DetailView()
        Text("Detail view")
    }
}
