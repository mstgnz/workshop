package main

import (
	"encoding/json"
	"fmt"
)

type person struct {
	Name       string   `json:"fullname"`
	Address    string   `json:"addr"`
	Age        int      `json:"age"`
	FaveColors []string `json:"favecolors"`
}

func decodeExample() {
	// declare some sample JSON data to decode
	data := []byte(`
		{
			"fullname" : "John Q Public",
			"addr" : "987 Main St",
			"age": 45,
			"favecolors" : ["Purple","White","Gold"]
		}
	`)

	// JSON will be decoded into a person struct
	var p person

	// test to see if the JSON is valid
	valid := json.Valid(data)
	if valid {
		// the Unmarhsal function decodes the JSON data into
		// the provided data structure
		err := json.Unmarshal(data, &p)
		if err != nil {
			return
		}
		fmt.Printf("%#v\n", p)
	}

	// data can also be decoded into a map structure
	var m map[string]interface{}

	// Unmarshal into a map
	err := json.Unmarshal(data, &m)
	if err != nil {
		return
	}
	fmt.Printf("%#v\n", m)
	for k, v := range m {
		fmt.Printf("key (%v), value (%T : %v)\n", k, v, v)
	}
}

func main() {
	// Decode JSON into go structs
	decodeExample()
}
