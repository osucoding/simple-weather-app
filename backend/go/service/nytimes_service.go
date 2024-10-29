package service

import (
	"github.com/osucoding/simple-weather-app/client"
	"github.com/osucoding/simple-weather-app/model"
)

func GetNews(sectionValue string) (model.NyTimesResponse, error) {
	return client.GetNews(sectionValue)
}
