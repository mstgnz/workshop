//
//  File.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

struct UserModel{
    var uid: String
    var email: String
    var firstname = ""
    var lastname = ""
    
    init(uid:String, email:String){
        self.uid = uid
        self.email = email
    }
}
