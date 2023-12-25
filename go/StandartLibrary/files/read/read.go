package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"os"
)

func handleErr(err error) {
	if err != nil {
		panic(err)
	}
}

func getFileLength(filepath string) int64 {
	f, err := os.Stat(filepath)
	handleErr(err)
	return f.Size()
}

func main() {
	// Use the ReadFile function to read an entire file
	content, err := ioutil.ReadFile("sampletext.txt")
	handleErr(err)
	// ReadFile reads the data as bytes, we have to convert to a string
	fmt.Println(string(content))

	f, _ := os.Open("sampletext.txt")
	defer f.Close()

	// The Read function can perform a generic read
	const BuffSize = 20
	b1 := make([]byte, BuffSize)

	for {
		n, err := f.Read(b1)

		if err != nil {
			if err != io.EOF {
				handleErr(err)
			}
			break
		}

		fmt.Println("Bytes read:", n)
		fmt.Println("Content:", string(b1[:n]))
	}

	// Get the length of a file
	l := getFileLength("sampletext.txt")
	fmt.Println("File length is:", l)

	// Use ReadAt to read from a specific index
	b2 := make([]byte, 10)
	_, err3 := f.ReadAt(b2, l-int64(len(b2)))
	handleErr(err3)
	fmt.Println(string(b2))
}
