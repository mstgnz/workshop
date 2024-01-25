//
//  WelcomeView.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct WelcomeView: View {
    @State var index = 1

    var body : some View{
        ScrollView(.vertical, showsIndicators: false) {
        VStack{
            Image("logo")
            .resizable()
            .frame(width: 200, height: 180)
            
            HStack{
                Button(action: {
                    withAnimation(.spring(response: 0.8, dampingFraction: 0.5, blendDuration: 0.5)){
                       self.index = 0
                    }
                }) {
                    Text("Existing")
                        .foregroundColor(self.index == 0 ? .black : .white)
                        .fontWeight(.bold)
                        .padding(.vertical, 10)
                        .frame(width: (UIScreen.main.bounds.width - 50) / 2)
                }.background(self.index == 0 ? Color.white : Color.clear)
                .clipShape(Capsule())
                
                Button(action: {
                   withAnimation(.spring(response: 0.8, dampingFraction: 0.5, blendDuration: 0.5)){
                      self.index = 1
                   }
                }) {
                    Text("New")
                        .foregroundColor(self.index == 1 ? .black : .white)
                        .fontWeight(.bold)
                        .padding(.vertical, 10)
                        .frame(width: (UIScreen.main.bounds.width - 50) / 2)
                    
                }.background(self.index == 1 ? Color.white : Color.clear)
                .clipShape(Capsule())
                
            }.background(Color.black.opacity(0.1))
            .clipShape(Capsule())
            .padding(.top, 25)
            
            if self.index == 0{
                SigninView()
            }else{
                SignupView()
            }
            
            if self.index == 0{
                
                Button(action: {
                    // Forget password action
                }) {
                    Text("Forget Password?")
                        .foregroundColor(.white)
                }
                .padding(.top, 20)
            }
            HStack(spacing: 15){
                Color.white.opacity(0.7)
                .frame(width: 35, height: 1)
                
                Text("Or")
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                
                Color.white.opacity(0.7)
                .frame(width: 35, height: 1)
            }
            .padding(.top, 10)
            
            HStack{
                Button(action: {
                    // Facebook login action
                }) {
                    Image("fb")
                        .renderingMode(.original)
                        .padding()
                    
                }.background(Color.white)
                .clipShape(Circle())
                Button(action: {
                    // Google login action
                }) {
                    Image("google")
                        .renderingMode(.original)
                        .padding()
                }.background(Color.white)
                .clipShape(Circle())
                .padding(.leading, 25)
            }
            .padding(.top, 10)
        }
        .padding()
        .offset(y:50)
        }
    }
}

struct WelcomeView_Previews: PreviewProvider {
    static var previews: some View {
        WelcomeView()
    }
}
