package api

import (
	"github.com/gin-gonic/gin"
)

type RegisterRequest struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func Register(c *gin.Context) {
	//var username, password = c.PostForm("username"), c.PostForm("password")

}
