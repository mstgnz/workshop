package main

import (
	"fmt"
	"time"
)

func Schedule(d time.Duration) <-chan struct{} {
	c := make(chan struct{}, 1)
	go func() {
		time.Sleep(d)
		c <- struct{}{}
	}()
	return c
}

func main() {
	for _, fast := range []string{"Dom", "Brian", "Letty", "Mia", "Roman", "Tej"} {
		fmt.Print(fast, " ")
		<-Schedule(time.Second)
	}
}
