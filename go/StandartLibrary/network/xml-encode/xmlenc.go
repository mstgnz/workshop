package main

import (
	"encoding/xml"
	"fmt"
)

type person struct {
	XMLName    xml.Name `xml:"persondata"`
	FirstName  string   `xml:"firstname"`
	LastName   string   `xml:"lastname"`
	Address    string   `xml:"addr"`
	Age        int      `xml:"age,attr"`
	FaveColors []string `xml:"favecolors"`
}

func main() {
	// Declare some sample data
	people := []person{
		{FirstName: "Jane", LastName: "Doe", Address: "123 Anywhere Street", Age: 35},
		{FirstName: "John", LastName: "Public", Address: "456 Everywhere Blvd", Age: 29,
			FaveColors: []string{"Purple", "Yellow", "Green"}},
	}

	// The MarshalIndent function indents the XML text
	result, err := xml.MarshalIndent(people, "", "\t")
	if err != nil {
		panic(err)
	}
	fmt.Printf("%s%s\n", xml.Header, result)
}
