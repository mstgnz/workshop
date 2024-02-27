package main

import (
	"embed"
	"fmt"
	"html/template"
	"net/http"
	"path"
	"strings"
)

// With this usage we have the possibility to create a template in the main directory and use it from there.
func render(w http.ResponseWriter, page string, data map[string]any, partials ...string) error {

	var t *template.Template
	var err error

	if len(partials) > 0 {
		partialPaths := make([]string, len(partials))
		for i, partial := range partials {
			partialPaths[i] = path.Join("./templates/components", fmt.Sprintf("%s.gohtml", partial))
		}

		templateFiles := append(partialPaths, path.Join("./templates/pages", fmt.Sprintf("%s.gohtml", page)), path.Join("./templates/index.gohtml"))

		t, err = template.ParseFiles(templateFiles...)
	} else {
		t, err = template.ParseFiles(path.Join("./templates/pages", fmt.Sprintf("%s.gohtml", page)), path.Join("./templates/index.gohtml"))
	}

	if err != nil {
		http.Error(w, "bad request", http.StatusBadRequest)
		return err
	}

	err = t.Execute(w, data)
	if err != nil {
		return err
	}

	return nil
}

// In this usage, the template directory has to be where main.go is.
var functions = template.FuncMap{
	"formatCurrency": formatCurrency,
}

func formatCurrency(n int) string {
	f := float32(n) / float32(100)
	return fmt.Sprintf("$%.2f", f)
}

//go:embed templates
var templateFS embed.FS

func renderTemplate(w http.ResponseWriter, page string, data map[string]any, partials ...string) error {
	var t *template.Template
	var err error
	templateToRender := fmt.Sprintf("templates/pages/%s.gohtml", page)

	t, err = parseTemplate(partials, page, templateToRender)
	if err != nil {
		return err
	}

	err = t.Execute(w, data)
	if err != nil {
		return err
	}

	return nil
}

func parseTemplate(partials []string, page, templateToRender string) (*template.Template, error) {
	var t *template.Template
	var err error

	// build partials
	if len(partials) > 0 {
		for i, x := range partials {
			partials[i] = fmt.Sprintf("templates/components/%s.gohtml", x)
		}
	}

	if len(partials) > 0 {
		t, err = template.New(fmt.Sprintf("%s.gohtml", page)).Funcs(functions).ParseFS(templateFS, "templates/index.gohtml", strings.Join(partials, ","), templateToRender)
	} else {
		t, err = template.New(fmt.Sprintf("%s.gohtml", page)).Funcs(functions).ParseFS(templateFS, "templates/index.gohtml", templateToRender)
	}
	if err != nil {
		return nil, err
	}

	return t, nil
}
