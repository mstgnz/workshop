package main

import (
	"html/template"
	"log"
	"net/http"
	"strings"

	"github.com/go-chi/chi/v5"
	"github.com/go-chi/chi/v5/middleware"
)

func main() {
	r := chi.NewRouter()

	r.Use(middleware.Logger)

	fileServer(r, "/assets", http.Dir("./assets"))

	r.Get("/", homeHandler)
	r.Get("/post", postHandler)

	log.Println("starting server on :8585")
	err := http.ListenAndServe(":8585", r)
	if err != nil {
		panic(err)
	}
}

func homeHandler(w http.ResponseWriter, r *http.Request) {
	if err := render(w, "home", map[string]any{"products": map[string]any{"test": template.HTML("<strong>test</strong>")}}, "navlink", "subscribe", "recommend", "scroll"); err != nil {
		log.Println(err)
	}
}

func postHandler(w http.ResponseWriter, r *http.Request) {
	if err := render(w, "post", map[string]any{"products": map[string]any{"test": template.HTML("<strong>test</strong>")}}, "navlink", "subscribe", "recommend", "scroll"); err != nil {
		log.Println(err)
	}
}

func fileServer(r chi.Router, path string, root http.FileSystem) {
	if strings.ContainsAny(path, "{}*") {
		panic("FileServer does not permit any URL parameters.")
	}

	// chi.StripPrefix ile servis edilecek route'u belirleyin
	r.Get(path+"*", http.StripPrefix(path, http.FileServer(root)).ServeHTTP)
}
