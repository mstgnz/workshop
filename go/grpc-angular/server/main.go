package main

import (
	"context"
	"fmt"
	"net"
	"net/http"

	"github.com/mstgnz/workshop/go/grpc-demo/proto"

	"google.golang.org/grpc"
)

func main() {

	listen, err := net.Listen("tcp", "localhost:9090")
	if err != nil {
		panic(err)
	}

	server := grpc.NewServer()
	proto.RegisterHelloServiceServer(server, &helloController{})

	fmt.Println("Running Server : 9090")

	panic(server.Serve(listen))

}

type helloController struct {
	proto.UnimplementedHelloServiceServer
}

func (h *helloController) SayHello(ctx context.Context, req *proto.HelloRequest) (*proto.HelloResponse, error) {
	return &proto.HelloResponse{Message: req.Name + "ben serverdan geldim :)"}, nil
}

func CORSMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Access-Control-Allow-Origin", "*") // change this later
		w.Header().Set("Access-Control-Allow-Credentials", "true")
		w.Header().Set("Access-Control-Allow-Headers", "Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization, accept, origin, Cache-Control, X-Requested-With")
		w.Header().Set("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS")

		if r.Method == "OPTIONS" {
			w.WriteHeader(204)
			return
		}

		next.ServeHTTP(w, r)
	})
}
