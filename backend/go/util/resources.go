package util

import (
	"os"
	"path/filepath"

	"gopkg.in/yaml.v3"
)

type NyTimesConfig struct {
	Nytimes struct {
		ApiKey string `yaml:"apiKey"`
		Uri    string `yaml:"uri"`
	} `yaml:"nytimes"`
}

type OpenWeatherConfig struct {
	OpenWeather struct {
		ApiKey string `yaml:"apiKey"`
		Uri    string `yaml:"uri"`
	} `yaml:"open-weather"`
}

func getApplicationYmlPath() string {
	cwd, err := os.Getwd()
	if err != nil {
		panic("could not get the current working directory")
	}
	path := filepath.Join(cwd, "resources/application.yml")
	return path
}

func GetOpenWeatherConfig() *OpenWeatherConfig {
	buffer, err := os.ReadFile(getApplicationYmlPath())
	if err != nil {
		panic("could not read the application.yml file")
	}

	openWeatherConfig := &OpenWeatherConfig{}
	err = yaml.Unmarshal(buffer, openWeatherConfig)
	if err != nil {
		panic("could not read the application.yml file")
	}
	return openWeatherConfig
}

func GetNyTimesConfig() *NyTimesConfig {
	buffer, err := os.ReadFile(getApplicationYmlPath())
	if err != nil {
		panic("could not read the application.yml file")
	}

	nyTimesConfig := &NyTimesConfig{}
	err = yaml.Unmarshal(buffer, nyTimesConfig)
	if err != nil {
		panic("could not read the application.yml file")
	}
	return nyTimesConfig
}
