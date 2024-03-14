package main

import (
	"log"
	"net/http"

	"github.com/mstgnz/workshop/go/template/handler"
)

var todoHandler handler.HTTPHandler

func main() {
	mux := http.NewServeMux()

	todoHandler = handler.NewTodoHandler()

	mux.HandleFunc("GET /todo", todoHandler.Get)
	mux.HandleFunc("POST /todo", todoHandler.Post)
	mux.HandleFunc("GET /todo/{id}", todoHandler.Get)
	mux.HandleFunc("PUT /todo/{id}", todoHandler.Put)
	mux.HandleFunc("PATCH /todo/{id}", todoHandler.Patch)
	mux.HandleFunc("DELETE /todo/{id}", todoHandler.Delete)

	log.Print("stated 3001...")
	err := http.ListenAndServe(":3001", mux)
	if err != nil {
		panic(err)
	}

}
