package controller

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
)

func SetupSampleController(engine *gin.Engine) {
	routerGroup := engine.Group("/api/v0/sample")

	routerGroup.GET("/say-hi", sayHi)
	routerGroup.GET("/say-my-name", sayMyName)
}

func sayHi(context *gin.Context) {
	context.JSON(http.StatusOK, "hello world")
}

func sayMyName(context *gin.Context) {
	parameterName := context.Query("name")
	if len(parameterName) == 0 {
		context.JSON(http.StatusBadRequest, "You must pass a name parameter")
		return
	}
	context.JSON(http.StatusOK, fmt.Sprintf("hello %v!", parameterName))
}
