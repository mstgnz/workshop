package handler

import (
	"net/http"
)

var js Json

type todoHandler struct {
}

func NewTodoHandler() *todoHandler {
	return &todoHandler{}
}

func (todoHandler) Get(w http.ResponseWriter, r *http.Request) {
	_ = js.WriteJSON(w, http.StatusOK, Response{Status: true, Message: "GET", Data: nil})
}

func (todoHandler) Post(w http.ResponseWriter, r *http.Request) {
	var data any
	_ = js.ReadJSON(w, r, &data)
	_ = js.WriteJSON(w, http.StatusOK, Response{Status: true, Message: "POST", Data: data})
}

func (todoHandler) Put(w http.ResponseWriter, r *http.Request) {
	data := r.PathValue("id")
	_ = js.WriteJSON(w, http.StatusOK, Response{Status: true, Message: "PUT", Data: data})
}

func (todoHandler) Patch(w http.ResponseWriter, r *http.Request) {
	data := r.PathValue("id")
	_ = js.WriteJSON(w, http.StatusOK, Response{Status: true, Message: "PATCH", Data: data})
}

func (todoHandler) Delete(w http.ResponseWriter, r *http.Request) {
	data := r.PathValue("id")
	_ = js.WriteJSON(w, http.StatusOK, Response{Status: true, Message: "DELETE", Data: data})
}
