//
//  UserStore.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import Firebase
import FirebaseAuth
import Combine

class SessionStore : ObservableObject {
    var didChange = PassthroughSubject<SessionStore, Never>()
    var user: UserModel? { didSet { self.didChange.send(self) } }
    @Published var isLogin = false
    //@Published var user: UserModel?
    
    var handle: AuthStateDidChangeListenerHandle?
    
    func listen(){
        handle = Auth.auth().addStateDidChangeListener  { (auth, user) in
            if let user = user{
                self.user = UserModel(uid: user.uid, email: user.email!)
                self.isLogin = true
            }else{
                self.user = nil
                self.isLogin = false
            }
        }
    }
    
    func signUp(email: String, password: String, repassword:String, handler: @escaping AuthDataResultCallback){
        if(password != repassword){
            print("paralolar eşleşmiyor")
        }else{
            Auth.auth().createUser(withEmail: email, password: password, completion: handler)
        }
    }
    
    func signIn(email: String, password: String, handler: @escaping AuthDataResultCallback){
        Auth.auth().signIn(withEmail: email, password: password, completion: handler)
    }
    
    func signOut(){
        do {
            try Auth.auth().signOut()
            self.user = nil
            self.isLogin = false
        } catch {
            print("hata: logout olunamadı")
        }
    }
    
    func unbind () {
        if let handle = handle {
            Auth.auth().removeStateDidChangeListener(handle)
        }
    }
}
