package main

import (
	"context"
	"fmt"
	"time"
)

func main() {
	ctx, cancel := context.WithCancel(context.Background())
	go func() {
		time.Sleep(3 * time.Second)
		cancel()
	}()
	running(ctx)
}

func running(ctx context.Context) {
	ticker := time.NewTicker(time.Second)
	for {
		select {
		case <-ticker.C:
			printing()
		case <-ctx.Done():
			return
		}
	}
}

func printing() { fmt.Println("running...") }
