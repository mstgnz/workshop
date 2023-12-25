package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func handleErr(err error) {
	if err != nil {
		panic(err)
	}
}

func checkFileExists(filePath string) bool {
	if _, err := os.Stat(filePath); err != nil {
		if os.IsNotExist(err) {
			return false
		}
	}
	return true
}

func writeFileData() {
	// create a new file
	f, err := os.Create("testfile.txt")
	handleErr(err)

	// it is idiomatic in go to defer the close after you open the file
	defer func(f *os.File) {
		err = f.Close()
		if err != nil {
			return
		}
	}(f)

	// get the Name of the file
	fmt.Println("The file is named ", f.Name())

	// write some string data to the file
	_, err = f.WriteString("This is a some text\n")
	if err != nil {
		return
	}

	// write some individual bytes to the file
	data2 := []byte{'a', 'b', 'c', '\n'}
	_, err = f.Write(data2)
	if err != nil {
		return
	}

	// the Sync function forces the data to be written out
	err = f.Sync()
	if err != nil {
		return
	}
}

func appendFileData(fname string, data string) {
	// Use the lower-level OpenFile function to open the file in append mode
	f, err := os.OpenFile(fname, os.O_APPEND|os.O_WRONLY, 0644)
	handleErr(err)
	defer func(f *os.File) {
		err = f.Close()
		if err != nil {
			return
		}
	}(f)

	_, err = f.WriteString(data)
	handleErr(err)
}

func main() {
	// Simple example: dump some data to a file
	data1 := []byte("Here is some text data\n")
	err := ioutil.WriteFile("datafile.txt", data1, 0644)
	if err != nil {
		return
	}

	// More complex example: Granular writing of data
	if !checkFileExists("testfile.txt") {
		writeFileData()
	} else {
		err = os.Truncate("testfile.txt", 10)
		if err != nil {
			return
		}
		fmt.Println("Trimmed the file data")
	}

	// Append data to the file
	appendFileData("datafile.txt", "This data was appended")
}
