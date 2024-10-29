package controller

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
)

func SetupSampleController(engine *gin.Engine) {
	routerGroup := engine.Group("/api/v0/sample")

	routerGroup.GET("/sayHi", sayHi)
	routerGroup.GET("/sayMyName", sayMyName)
}

func sayHi(context *gin.Context) {
	context.String(http.StatusOK, "hello world")
}

func sayMyName(context *gin.Context) {
	parameterName := context.Query("name")
	if len(parameterName) == 0 {
		context.String(http.StatusBadRequest, "You must pass a name parameter")
		return
	}
	context.String(http.StatusOK, fmt.Sprintf("hello %v!", parameterName))
}
