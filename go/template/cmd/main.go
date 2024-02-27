package main

import (
	"log"
	"net/http"

	"github.com/go-chi/chi/v5"
	"github.com/go-chi/chi/v5/middleware"
)

func main() {
	r := chi.NewRouter()
	r.Use(middleware.Logger)
	r.Get("/", homeHandler)
	r.Get("/2", homeHandler2)

	log.Println("starting server on :8585")
	err := http.ListenAndServe(":8585", r)
	if err != nil {
		panic(err)
	}
}

func homeHandler(w http.ResponseWriter, r *http.Request) {
	if err := renderTemplate(w, "home", nil); err != nil {
		log.Println(err)
	}
}

func homeHandler2(w http.ResponseWriter, _ *http.Request) {
	if err := render(w, "home", nil); err != nil {
		log.Println(err)
	}
}
