package main

import (
	"fmt"
	"os"
)

func checkFileExists(filePath string) bool {
	if _, err := os.Stat(filePath); err != nil {
		if os.IsNotExist(err) {
			return false
		}
	}

	return true
}

func main() {
	// Use the Stat function to get file stats
	stats, err := os.Stat("sampletext.txt")
	if err != nil {
		panic(err)
	}

	// Check if a file exists
	exists := checkFileExists("sampletext.txt")
	fmt.Println("File exists check:", exists)

	// Get the file's modification time
	fmt.Println("Modification time:", stats.ModTime())

	fmt.Println("File mode:", stats.Mode())
	fmode := stats.Mode()
	if fmode.IsRegular() {
		fmt.Println("This is a regular file")
	}

	// Get the file size
	fmt.Println("The length of the file is:", stats.Size())

	// Is this a directory?
	fmt.Println("Is directory:", stats.IsDir())
}
