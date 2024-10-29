package model

type ResultsItem struct {
	AbstractTitle string `json:"abstract"`
	Url           string `json:"url"`
	Byline        string `json:"byline"`
}

type NyTimesResponse struct {
	Results []ResultsItem `json:"results"`
}
