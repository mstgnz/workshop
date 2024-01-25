//
//  ProfileView.swift
//  letsroute
//
//  Created by Mesut Genez on 29.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct ProfileView: View {
    
    @EnvironmentObject var auth: SessionStore
    
    func getUserEmail () -> String{
        return self.auth.user?.email ?? " "
    }
    
    var body: some View {
        VStack{
            Text("Hello," + self.getUserEmail())
            Button(action: {
                self.auth.signOut()
            }) {
                Text("Logout")
            }
        }
    }
}

struct ProfileView_Previews: PreviewProvider {
    static var previews: some View {
        ProfileView().environmentObject(SessionStore())
    }
}
