package routers

import (
	"github.com/gin-gonic/gin"
	"spokenbot/routers/api"
)

func InitRouters() *gin.Engine {
	r := gin.Default()
	r.POST("/api/user/register", api.Register)
	return r
}
