package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"spokenbot/models"
	"spokenbot/pkg/settings"
	"spokenbot/routers"
)

func init() {
	models.Setup()
	settings.Setup()
	fmt.Println("init complete")
}
func main() {
	r := routers.InitRouters()

	r.Run("localhost:8080")
}

// very naive
func helloworld(c *gin.Context) {
	c.JSON(200, gin.H{
		"message": "Hello golang!",
	})
}

type Response struct {
	Code    int         `json: "code"`
	Message string      `json: "message"'`
	Data    interface{} `json: "data"`
}

// get a value from path and return json
func testgetpath(c *gin.Context) {
	code := c.Param("code")

	resp := Response{
		Code:    200,
		Message: "success",
		Data:    code,
	}
	c.JSON(200, resp)
}

// read data from query and return json
func testgetquery(c *gin.Context) {
	params := c.Request.URL.Query()
	name := params.Get("name")
	data := make(map[string]string)
	data["name"] = name

	resp := Response{
		Code:    200,
		Message: "success",
		Data:    data,
	}
	c.JSON(200, resp)
}

// read data from body and return json
type Login struct {
	Username string
	Password string
}

func testpost(c *gin.Context) {
	var login Login
	c.BindJSON(&login)

	resp := Response{
		Code:    200,
		Message: "success",
		Data:    login,
	}

	c.JSON(200, resp)
}

// parse parameter and return json
func testpostform(c *gin.Context) {
	name := c.PostForm("name")
	c.JSON(200, name)
}
