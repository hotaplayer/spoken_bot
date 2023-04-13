package settings

import "github.com/BurntSushi/toml"

type AppConfig struct {
	Server   ServerConfig
	Database DatabaseConfig
}

type ServerConfig struct {
	Port int
}

type DatabaseConfig struct {
	Host         string
	Port         int
	DatabaseName string
}

var Config AppConfig

func Setup() {
	if _, err := toml.DecodeFile("conf/app.toml", &Config); err != nil {
		panic(err)
	}
}
