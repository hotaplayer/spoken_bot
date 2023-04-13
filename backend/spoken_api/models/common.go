package models

import (
	"time"
)

type CommonModel struct {
	CreatedAt time.Time
	UpdatedAt time.Time
}

func Setup() {
	//gorm.Open()
}
