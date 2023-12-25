package main

import (
	"encoding/json"
	"fmt"
)

type person struct {
	Name       string   `json:"fullname"`
	Address    string   `json:"addr"`
	Age        int      `json:"age"`
	FaveColors []string `json:"favecolors,omitempty"`
}

func encodeExample() {
	// create some people data
	people := []person{
		{"Jane Doe", "123 Anywhere Street", 35, nil},
		{"John Public", "456 Everywhere Blvd", 29, []string{"Purple", "Yellow", "Green"}},
	}

	// Marshal is used to convert a data structure to JSON format
	// MarshalIndent is used to format the JSON string with indentation
	result, err := json.MarshalIndent(people, "", "\t")
	if err != nil {
		panic(err)
	}
	fmt.Printf("%s\n", result)
}

func main() {
	// Encode go data as JSON
	encodeExample()
}
