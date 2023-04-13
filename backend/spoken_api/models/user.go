package models

import (
	"math/big"
)

type UserEntity struct {
	CommonModel
	Id       *big.Int `gorm:"column:pk_id;primary_key;auto_increment:true"`
	Username string   `gorm:"column:username;unique_index"`
	PwdHash  string   `gorm:"column:pwd_hash"`
}

func RegisterUser() {

}

func (UserEntity) TableName() string {
	return "t_user_info"
}
