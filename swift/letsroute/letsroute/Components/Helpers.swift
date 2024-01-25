//
//  AlertComp.swift
//  letsroute
//
//  Created by Mesut Genez on 25.07.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI

class Helpers{
    
    func alert(title:String, message:String){
        let alert = UIAlertController(
            title: title,
            message: message,
            preferredStyle: .alert
        )
        alert.addAction(UIAlertAction(title: "Ok", style: .default, handler: nil))
    }
}
