package main

import (
	"fmt"
	"time"
)

func main() {
	furious := []string{"Dom", "Brian", "Letty", "Mia", "Roman", "Tej"}
	cars := []string{"Honda", "Nissan", "Jensen", "Dodge", "Chevrolet"}

	go listSpaceships(cars)

	go func(items []string) {
		for i := range items {
			fmt.Printf("Hero: %s\n", items[i])
			time.Sleep(time.Second)
		}
	}(furious)

	// This value is entered because it is estimated that the program will take less than 5 seconds to run.
	// In real life we cannot know the running time of the program. This type of blocking should not be used in real life.
	<-time.After(time.Second * 10)
}

func listSpaceships(items []string) {
	for i := range items {
		fmt.Printf("Car: %s\n", items[i])
		time.Sleep(time.Second)
	}
}
