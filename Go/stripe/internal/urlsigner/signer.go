package urlsigner

import (
	"fmt"
	"strings"
	"time"

	goAlone "github.com/bwmarrin/go-alone"
)

type Signer struct {
	Secret []byte
}

func (s *Signer) GenerateTokenFromString(data string) string {
	var urlToSign string

	crypt := goAlone.New(s.Secret, goAlone.Timestamp)
	if strings.Contains(data, "?") {
		urlToSign = fmt.Sprintf("%s&hash=", data)
	} else {
		urlToSign = fmt.Sprintf("%s?hash=", data)
	}

	tokenBytes := crypt.Sign([]byte(urlToSign))
	token := string(tokenBytes)
	return token
}

func (s *Signer) VerifyToken(token string) bool {
	crypt := goAlone.New(s.Secret, goAlone.Timestamp)
	_, err := crypt.Unsign([]byte(token))

	if err != nil {
		fmt.Println(err)
		return false
	}

	return true
}

func (s *Signer) Expired(token string, minutesUntilExpire int) bool {
	crypt := goAlone.New(s.Secret, goAlone.Timestamp)
	ts := crypt.Parse([]byte(token))

	return time.Since(ts.Timestamp) > time.Duration(minutesUntilExpire)*time.Minute
}
