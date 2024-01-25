//
//  SearchView.swift
//  letsroute
//
//  Created by Mesut Genez on 29.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct SearchView: View {
    
    @ObservedObject var placeStore = PlaceStore()
    
    var body: some View {
        VStack{
            Text("Search View")
            Button(action: {
                self.placeStore.addPlace(title: "app title", description: "app description", latitude: 34.3434344, longitude: 34.5434322, image: "resmim.png")
            }) {
                Text("Kaydet")
            }
        }
    }
}

struct SearchView_Previews: PreviewProvider {
    static var previews: some View {
        SearchView()
    }
}
