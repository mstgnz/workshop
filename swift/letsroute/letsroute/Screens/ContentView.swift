//
//  ContentView.swift
//  letsroute
//
//  Created by Mesut Genez on 21.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import Firebase

struct ContentView: View {
    
    @State var isLogin = false
    @EnvironmentObject var auth: SessionStore
    
    func getUser () {
        self.auth.listen()
    }
    
    var body: some View {
        ZStack{
            LinearGradient(gradient: .init(colors: [Color("Color"),Color("Color1"),Color("Color2")]), startPoint: .top, endPoint: .bottom)
            
            Group{
                if self.auth.isLogin{
                    HomeView()
                }else{
                    WelcomeView()
                }
            }.onAppear(perform: getUser)
        }.edgesIgnoringSafeArea(.all)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environmentObject(SessionStore())
    }
}
