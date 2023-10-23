package main

import (
	"fmt"
	"time"
)

func producer(ch chan int) {
	for i := 0; i < 10; i++ {
		ch <- i
		fmt.Printf("write %v to channel\n", i)
	}
	close(ch)
}
func main() {
	ch := make(chan int, 4)
	go producer(ch)
	time.Sleep(2 * time.Second)

	for v := range ch {
		fmt.Printf("read %v from channel\n", v)
		time.Sleep(2 * time.Second)
	}
}
