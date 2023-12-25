package main

import (
	"fmt"
	"time"
)

func main() {

	go func() {
		for i := 1; i <= 10; i++ {
			time.Sleep(200 * time.Millisecond)
			fmt.Printf("%d ", i)
		}
	}()

	go func() {
		for i := 'Z'; i >= 'Q'; i-- {
			time.Sleep(200 * time.Millisecond)
			fmt.Printf("%c ", i)
		}
	}()

	// This value is entered because it is estimated that the program will take less than 5 seconds to run.
	// In real life we cannot know the running time of the program. This type of blocking should not be used in real life.
	<-time.After(time.Second * 5)
}
