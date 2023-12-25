package main

import (
	"fmt"
	"time"
)

func main() {
	numbers := []string{"one", "two", "three", "four", "five"}
	numChan := make(chan string)

	go func() {
		for i := 0; i < len(numbers); i++ {
			findNum := <-numChan
			fmt.Println(findNum)
		}
	}()

	go func(numbers []string) {
		for _, number := range numbers {
			numChan <- number
		}
	}(numbers)

	// This value is entered because it is estimated that the program will take less than 5 seconds to run.
	// In real life we cannot know the running time of the program. This type of blocking should not be used in real life.
	<-time.After(time.Second * 5)
}
