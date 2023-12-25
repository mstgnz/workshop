package main

import (
	"fmt"
	"time"
)

func process(ch chan []string) {
	time.Sleep(5500 * time.Millisecond)
	fast := []string{"Dom", "Brian", "Letty", "Mia", "Roman", "Tej"}
	ch <- fast
}

func main() {
	ch := make(chan []string)
	go process(ch)
	for {
		time.Sleep(1500 * time.Millisecond)
		select {
		case v := <-ch:
			fmt.Printf("received value: %s", v)
			return
		default:
			fmt.Println("no value received")
		}
	}
}
