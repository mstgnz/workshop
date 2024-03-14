run:
	find . -type f -name '*.go' | entr -r sh -c 'go build -o /tmp/build ./cmd && /tmp/build'