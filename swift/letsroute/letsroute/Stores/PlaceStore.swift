//
//  PlacesStore.swift
//  letsroute
//
//  Created by Mesut Genez on 1.08.2020.
//  Copyright © 2020 Mesut Genez. All rights reserved.
//

import SwiftUI
import Firebase
import Combine

class PlaceStore: ObservableObject{
    let db = Firestore.firestore()
    var didChange = PassthroughSubject<Array<Any>, Never>()
    @Published var placeArray: [PlaceModel] = []
    
    init(){
        db.collection("Places").addSnapshotListener { (snapshot, error) in
            if(error != nil){
                print("Hata: \(error?.localizedDescription.description ?? "bişey var")")
            }else{
                self.placeArray.removeAll(keepingCapacity: true)
                for document in snapshot!.documents{
                    if let title = document.get("title") as? String{
                        if let description = document.get("description") as? String{
                            if let geopoint = document.get("geopoint") as? GeoPoint{
                                if let image = document.get("image") as? String{
                                    if let createDate = document.get("createDate") as? String{
                                        let uid = document.documentID
                                        let formatter = DateFormatter()
                                        formatter.dateFormat = "yyyy/MM/dd hh:mm:ss"
                                        let getDate = formatter.date(from: createDate)
                                        let getPlaces = PlaceModel(id: UUID(), uid: uid, title: title, description: description, geopoint: geopoint, image: image, createDate: getDate!)
                                        self.placeArray.append(getPlaces)
                                    }
                                }
                            }
                        }
                    }
                }
                self.didChange.send(self.placeArray)
            }
        }
    }
    
    func addPlace(title:String, description:String, latitude:Double, longitude:Double, image:String){
        var ref: DocumentReference? = nil
        
        let placeDict: [String:Any] = [
            "uid": Auth.auth().currentUser!.uid,
            "title": title,
            "description": description,
            "geopoint": GeoPoint.init(latitude: latitude, longitude: longitude),
            "image": image,
            "createDate": generateDate()
        ]
        
        ref = self.db.collection("Places").addDocument(data: placeDict, completion: { (error) in
            if(error != nil){
                print("Hata \(error?.localizedDescription.description ?? "Data Eklenemedi")")
            }else{
                print("kayıt başarılı")
            }
        })
        
    }
    
    func generateDate() -> String{
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy/MM/dd hh:mm:ss"
        return (formatter.string(from: Date()) as NSString) as String
    }
}
