import yaml
from typing import Dict
import os

# Get the current file's directory
base_dir = os.path.dirname(os.path.abspath(__file__))  # Directory of the current file
resources_yaml_path = os.path.join(base_dir, '../resources/application.yml')

class APIResource:
    def __init__(self, api_key: str, uri: str) -> None:
        self.api_key = api_key
        self.uri = uri

def load_config() -> Dict:
    """Load the YAML configuration file."""
    with open(resources_yaml_path, 'r') as file:
        return yaml.safe_load(file)

def get_ny_times_api_resource() -> APIResource:
    config = load_config()
    api_key = config['nytimes']['apiKey']
    uri = config['nytimes']['uri']
    return APIResource(api_key, uri)

def get_simple_weather_api_resource() -> APIResource:
    config = load_config()
    api_key = config['open-weather']['apiKey']
    uri = config['open-weather']['uri']
    return APIResource(api_key, uri)