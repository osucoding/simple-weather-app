package main

import (
	"github.com/gin-gonic/gin"
	"github.com/osucoding/simple-weather-app/controller"
)

func main() {
	server := gin.Default()

	// set up sample controllers
	controller.SetupSampleController(server)

	server.Run(":8083")
}
