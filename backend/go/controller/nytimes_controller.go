package controller

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/osucoding/simple-weather-app/service"
)

func SetupNyTimesController(engine *gin.Engine) {
	routerGroup := engine.Group("/api/v0/ny-times")

	routerGroup.GET("/news", getNews)
}

func getNews(context *gin.Context) {
	sectionValue := context.Query("sectionValue")
	if len(sectionValue) == 0 {
		context.JSON(http.StatusBadRequest, "Not a valid sectionValue")
		return
	}

	nyTimesResponse, err := service.GetNews(sectionValue)
	if err != nil {
		context.JSON(http.StatusBadRequest, "Error during API call to NYTimes")
		return
	}
	context.JSON(http.StatusOK, nyTimesResponse)
}
