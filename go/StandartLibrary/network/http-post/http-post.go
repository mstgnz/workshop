package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"net/url"
)

func postRequestTest() {
	const httpbin = "https://httpbin.org/post"

	// POST operation using Post
	// reqBody := strings.NewReader(`
	// {
	// 	"field1" : "This is field 1"
	// 	"field2" : 250
	// }
	// `)
	// resp, err := http.Post(httpbin, "application/json", reqBody)

	// POST operation using PostForm
	data := url.Values{}
	data.Add("field1", "field added via Values")
	data.Add("field2", "300")
	resp, err := http.PostForm(httpbin, data)
	if err != nil {
		return
	}

	content, _ := ioutil.ReadAll(resp.Body)
	defer func(Body io.ReadCloser) {
		err = Body.Close()
		if err != nil {
			return
		}
	}(resp.Body)
	fmt.Printf("%s\n", content)
}

func main() {
	// Execute a POST
	postRequestTest()
}
