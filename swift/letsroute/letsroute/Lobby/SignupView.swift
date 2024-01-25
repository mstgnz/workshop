//
//  SignupView.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct SignupView: View {    
    @State var mail = ""
    @State var pass = ""
    @State var repass = ""
    @State var passNotMatch = false
    @State var passSee: Bool = false
    @State var repassSee: Bool = false
    @EnvironmentObject var auth: SessionStore
    var helpers = Helpers()

    var body : some View{
        
        VStack{
            VStack{
                HStack(spacing: 15){
                    Image(systemName: "envelope")
                        .foregroundColor(.black)
                    
                    TextField("Enter Email Address", text: self.$mail).autocapitalization(UITextAutocapitalizationType.none)
                    
                }.padding(.vertical, 20)
                
                Divider()
                
                HStack(spacing: 15){
                    
                    Image(systemName: "lock")
                    .resizable()
                    .frame(width: 15, height: 18)
                    .foregroundColor(.black)
                    
                    if(self.passSee){
                        TextField("Password", text: self.$pass).autocapitalization(UITextAutocapitalizationType.none)
                    }else{
                        SecureField("Password", text: self.$pass)
                    }
                    
                    Button(action: {
                        self.passSee = !self.passSee
                    }) {
                        Image(systemName: "eye")
                            .foregroundColor(.black)
                    }
                }.padding(.vertical, 20)
                
                Divider()

                HStack(spacing: 15){
                    Image(systemName: "lock")
                    .resizable()
                    .frame(width: 15, height: 18)
                    .foregroundColor(.black)
                    
                    if(self.repassSee){
                        TextField("Re-Enter", text: self.$repass).autocapitalization(UITextAutocapitalizationType.none)
                    }else{
                        SecureField("Re-Enter", text: self.$repass)
                    }
                    
                    Button(action: {
                         self.repassSee = !self.repassSee
                    }) {
                        Image(systemName: "eye")
                            .foregroundColor(.black)
                    }
                }.padding(.vertical, 20)
            }
            .padding(.vertical)
            .padding(.horizontal, 20)
            .padding(.bottom, 40)
            .background(Color.white)
            .cornerRadius(10)
            .padding(.top, 25)
            
            Button(action: {
                if(self.pass != self.repass){
                    Helpers().alert(title: "Hata!", message:"password not matched")
                    self.helpers.alert(title: "selfli", message: "eşleşmiyomuş")
                    
                    print("eşleşmiyor")
                }else{
                    self.auth.signUp(email: self.mail, password: self.pass, repassword: self.repass) { (result, error) in
                        if(error != nil){
                            //Helpers().alert(title: "Hata!", message: error?.localizedDescription ?? "bilgilerinizi kontrol ediniz")
                
                        }else{
                            print("kayıt başarılı")
                            self.mail = ""
                            self.pass = ""
                            self.repass = ""
                        }
                    }
                }
            }) {
                Text("SIGNUP")
                    .foregroundColor(.white)
                    .fontWeight(.bold)
                    .padding(.vertical)
                    .frame(width: UIScreen.main.bounds.width - 100)
                
            }.background(
            
                LinearGradient(gradient: .init(colors: [Color("Color2"),Color("Color1"),Color("Color")]), startPoint: .leading, endPoint: .trailing)
            )
            .cornerRadius(8)
            .offset(y: -40)
            .padding(.bottom, -40)
            .shadow(radius: 15)
        }
    }
}

struct SignupView_Previews: PreviewProvider {
    static var previews: some View {
        SignupView().environmentObject(SessionStore())
    }
}
