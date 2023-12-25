package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"strings"
)

func getRequestTest() {
	const httpbin = "https://httpbin.org/get"

	// Perform a GET operation
	resp, err := http.Get(httpbin)
	if err != nil {
		return
	}
	// The caller is responsible for closing the response
	defer func(Body io.ReadCloser) {
		err = Body.Close()
		if err != nil {
			return
		}
	}(resp.Body)

	// We can access parts of the response to get information:
	fmt.Println("Status:", resp.Status)
	fmt.Println("Status Code:", resp.StatusCode)
	fmt.Println("Protocol:", resp.Proto)
	fmt.Println("Content length:", resp.ContentLength)

	// Use a String Builder to build the content from bytes
	var sb strings.Builder

	// Read the content and write it to the builder
	content, _ := ioutil.ReadAll(resp.Body)
	bytecount, _ := sb.Write(content)

	// Format the output
	fmt.Println(bytecount, sb.String())
}

func main() {
	// Execute a GET request
	getRequestTest()
}
