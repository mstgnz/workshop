package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func hello(c chan string) {
	time.Sleep(time.Second * 2)
	c <- "Hello"
}

func helloWg() {
	fmt.Println("Hello -> wait group")
	wg.Done()
}

func main() {

	wg.Add(1)

	c := make(chan string)

	go hello(c)
	fmt.Println("test")

	fmt.Println(<-c)

	go helloWg()

	wg.Wait()
}
