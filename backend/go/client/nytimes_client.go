package client

import (
	"encoding/json"
	"fmt"
	"io"
	"net/http"

	"github.com/osucoding/simple-weather-app/model"
	"github.com/osucoding/simple-weather-app/util"
)

func GetNews(sectionValue string) (model.NyTimesResponse, error) {
	nyTimesConfig := util.GetNyTimesConfig()

	url := fmt.Sprintf("%s%s.json?api-key=%s", nyTimesConfig.Nytimes.Uri, sectionValue, nyTimesConfig.Nytimes.ApiKey)

	response, err := http.Get(url)
	if err != nil {
		return model.NyTimesResponse{}, err
	}

	body, err := io.ReadAll(response.Body)
	if err != nil {
		return model.NyTimesResponse{}, err
	}

	var news model.NyTimesResponse
	if err := json.Unmarshal(body, &news); err != nil {
		return model.NyTimesResponse{}, err
	}

	return news, nil
}
