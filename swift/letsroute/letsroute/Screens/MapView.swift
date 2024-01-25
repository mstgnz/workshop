//
//  SettingView.swift
//  letsroute
//
//  Created by Mesut Genez on 29.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import MapKit

struct MapView: UIViewRepresentable {
    
    // direk açıldığında kullanıcının kordinatını aç
    // mekan listesinden tıklandığında tıklanan mekanın kordinatını aç
    var coordinate: CLLocationCoordinate2D
    
    func makeUIView(context: Context) -> MKMapView {
        //MKMapView(frame: .zero)
        let mapView = MKMapView(frame: .zero)
        mapView.delegate = context.coordinator
        
        let longPressed = UILongPressGestureRecognizer(target:
            context.coordinator, action: #selector(context.coordinator.addPin(gesture:)))
        //longPressed.numberOfTouchesRequired = 2
        mapView.addGestureRecognizer(longPressed)
        
        return mapView
    }
    
    func updateUIView(_ uiView: MKMapView, context: Context) {
        let span = MKCoordinateSpan(latitudeDelta: 0.01, longitudeDelta: 0.01)
        let region = MKCoordinateRegion(center: coordinate, span: span)
        uiView.setRegion(region, animated: true)
        
        let annotation = MKPointAnnotation()
        annotation.coordinate = coordinate
        annotation.title = "My Location"
        annotation.subtitle = "My Location"
        uiView.addAnnotation(annotation)
    }
    
    func makeCoordinator() -> MapViewCoordinator {
        MapViewCoordinator()
    }
    
}

struct SettingView_Previews: PreviewProvider {
    static var previews: some View {
        MapView(coordinate: CLLocationCoordinate2D(latitude: 41.039242, longitude: 28.999499))
    }
}


class MapViewCoordinator: NSObject, MKMapViewDelegate {

    @objc func addPin(gesture: UILongPressGestureRecognizer) {
        print("hey")
    }

}
