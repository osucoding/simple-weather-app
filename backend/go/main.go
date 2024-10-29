package main

import (
	"github.com/gin-gonic/gin"
	"github.com/osucoding/simple-weather-app/controller"
)

func disableCors(server *gin.Engine) {
	// CORS middleware
	server.Use(func(c *gin.Context) {
		c.Header("Access-Control-Allow-Origin", "*")                                // Allow all origins
		c.Header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS") // Allowed methods
		c.Header("Access-Control-Allow-Headers", "Content-Type")                    // Allowed headers

		// Handle preflight requests
		if c.Request.Method == "OPTIONS" {
			c.AbortWithStatus(204) // No Content
			return
		}

		c.Next()
	})
}

func main() {
	server := gin.Default()

	disableCors(server)

	// set up sample controllers
	controller.SetupSampleController(server)
	// set up NY Times controller
	controller.SetupNyTimesController(server)

	server.Run(":8083")
}
