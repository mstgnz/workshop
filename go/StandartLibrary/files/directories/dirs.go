package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func main() {
	// create a directory
	err := os.Mkdir("newdir", os.ModePerm)
	if err != nil {
		return
	}
	// Remove will remove an item
	defer func() {
		err = os.Remove("newdir")
		if err != nil {
			return
		}
	}()

	// create a deep directory
	err = os.MkdirAll("path/to/new/dir", os.ModePerm)
	if err != nil {
		return
	}
	// RemoveAll will remove an item and all children
	defer func() {
		err = os.RemoveAll("path")
		if err != nil {
			return
		}
	}()

	// get the current working directory
	dir, _ := os.Getwd()
	fmt.Println("Current dir is:", dir)

	// get the directory of the current process
	exedir, _ := os.Executable()
	fmt.Println("Current dir is:", exedir)

	// read the contents of a directory
	contents, _ := ioutil.ReadDir(".")
	for _, fi := range contents {
		fmt.Println(fi.Name(), fi.IsDir())
	}
}
