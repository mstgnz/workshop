//
//  ListView.swift
//  letsroute
//
//  Created by Mesut Genez on 30.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct ListView: View {
    
    @ObservedObject var placeStore = PlaceStore()
    
    var body: some View {
        NavigationView{
            List(placeStore.placeArray){ place in
                NavigationLink(destination: DetailView(place: place)) {
                    Text(place.title)
                }
            }
        }
    }
}

struct ListView_Previews: PreviewProvider {
    static var previews: some View {
        ListView()
    }
}
