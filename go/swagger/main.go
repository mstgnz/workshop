package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"strings"

	httpSwagger "github.com/swaggo/http-swagger"
)

type User struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
}

var users = []User{
	{
		ID:   1,
		Name: "John Doe",
	},
	{
		ID:   2,
		Name: "Jane Doe",
	},
}

func usersList(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	marshall, _ := json.Marshal(users)
	_, _ = w.Write(marshall)
}

func usersCreate(w http.ResponseWriter, r *http.Request) {
	var user User
	err := json.NewDecoder(r.Body).Decode(&user)
	if err != nil {
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	users = append(users, user)

	fmt.Println("Created user:", user)
	w.WriteHeader(http.StatusCreated)
}

func usersUpdate(w http.ResponseWriter, r *http.Request) {
	// Extract user ID from the URL path
	id := strings.TrimPrefix(r.URL.Path, "/users/update/")
	idInt := 0
	_, _ = fmt.Sscanf(id, "%d", &idInt)

	if idInt == 0 {
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	var user User
	err := json.NewDecoder(r.Body).Decode(&user)
	if err != nil {
		w.WriteHeader(http.StatusBadRequest)
		return
	}
	// Update user with the specified ID
	for i := range users {
		if users[i].ID == idInt {
			users[i] = user
			break
		}
	}

	fmt.Println("Updated user:", user)
	w.WriteHeader(http.StatusOK)
}

func usersDelete(w http.ResponseWriter, r *http.Request) {
	// Extract user ID from the URL path
	id := strings.TrimPrefix(r.URL.Path, "/users/delete/")
	idInt := 0
	_, _ = fmt.Sscanf(id, "%d", &idInt)

	if idInt == 0 {
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	// Delete user with the specified ID
	for i := range users {
		if users[i].ID == idInt {
			users = append(users[:i], users[i+1:]...)
			break
		}
	}

	fmt.Println("Deleted user:", idInt)
	w.WriteHeader(http.StatusNoContent)
}

func main() {
	http.HandleFunc("/users", usersList)
	http.HandleFunc("/users/create", usersCreate)
	http.HandleFunc("/users/update", usersUpdate)
	http.HandleFunc("/users/delete", usersDelete)

	http.Handle("/docs/", http.StripPrefix("/docs/", http.FileServer(http.Dir("docs"))))
	http.Handle("/swagger/", httpSwagger.Handler(
		httpSwagger.URL("/docs/swagger.yaml"), // Update the URL as needed
	))

	if err := http.ListenAndServe(":9090", nil); err != nil {
		log.Fatal(err)
	}
}
