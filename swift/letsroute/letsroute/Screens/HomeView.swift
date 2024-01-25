//
//  HomeView.swift
//  letsroute
//
//  Created by Mesut Genez on 24.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import MapKit
import CoreLocation

struct HomeView: View {
    @State var selected = 0
    @ObservedObject var locationManager = LocationManager()

    let width = UIScreen.main.bounds.width
    let height = UIScreen.main.bounds.height
    
    var body: some View {
        ZStack(alignment: .bottom){
            if(self.selected==0){
                ListView()  
            }else if(self.selected==1){
                SearchView().frame(width: self.width, height: self.height)
            }else if(self.selected==2){
               ProfileView().frame(width: self.width, height: self.height)
            }else{
                MapView(coordinate: CLLocationCoordinate2D(latitude: locationManager.lastLocation?.coordinate.latitude ?? 0, longitude: locationManager.lastLocation?.coordinate.longitude ?? 0)).frame(width: self.width, height: self.height+20)
            }
            BottomBar(selected: self.$selected)
                .padding()
                .padding(.horizontal, 25)
                .background(CurvedShape())
            Button(action: {
                print("beğendim")
            }) {
                Image("Wishlist").renderingMode(.original).padding(18)
            }.background(Color.yellow)
            .clipShape(Circle())
            .offset(y: -52)
            .shadow(radius: 5)
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}

struct CurvedShape : View {
    
    var body : some View{
        Path{path in
            path.move(to: CGPoint(x: 0, y: 0))
            path.addLine(to: CGPoint(x: UIScreen.main.bounds.width, y: 0))
            path.addLine(to: CGPoint(x: UIScreen.main.bounds.width, y: 80))
            path.addArc(center: CGPoint(x: UIScreen.main.bounds.width / 2, y: 80), radius: 30, startAngle: .zero, endAngle: .init(degrees: 180), clockwise: true)
            path.addLine(to: CGPoint(x: 0, y: 80))
        }.fill(Color.white)
        .rotationEffect(.init(degrees: 180))
    }
}

struct BottomBar : View {
    
    @Binding var selected : Int
    
    var body : some View{
        
        HStack{
            Button(action: {
                self.selected = 0
            }) {
                Image(systemName:"house.fill").font(.system(size:22))
            }.foregroundColor(self.selected == 0 ? .black : .gray).offset(y:-10)
            
            Spacer(minLength: 12)
        
            Button(action: {
                self.selected = 1
            }) {
                Image(systemName:"magnifyingglass.circle.fill").font(.system(size:28))
            }.foregroundColor(self.selected == 1 ? .black : .gray).offset(y:-10)
            
            Spacer().frame(width: 120)
            
            Button(action: {
                self.selected = 2
            }) {
                Image(systemName:"person.fill").font(.system(size:28))
            }.foregroundColor(self.selected == 2 ? .black : .gray).offset(y:-10)
            
            Spacer(minLength: 12)
            
            Button(action: {
                self.selected = 3
            }) {
                Image(systemName:"map.fill").font(.system(size:25))
            }.foregroundColor(self.selected == 3 ? .black : .gray).offset(y:-10)
        }
    }
}
