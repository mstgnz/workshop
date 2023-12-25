package main

import (
	"fmt"
	"time"
)

func main() {
	start := make(chan struct{})
	for i := 0; i < 10000; i++ {
		go func(k int) {
			<-start // blocking
			fmt.Println(k)
		}(i)
	}

	time.Sleep(1 * time.Second)

	close(start)
}
