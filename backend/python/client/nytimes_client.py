import requests

from model.ny_times import NyTimesResponse, ResultsItem
from util.resources import get_ny_times_api_resource


def get_news(section_value: str) -> NyTimesResponse:
    # get APIResource
    ny_times_api_config = get_ny_times_api_resource()
    params = {
        'api-key': ny_times_api_config.api_key
    }

    base_url = f'{ny_times_api_config.uri}{section_value}.json'

    response = requests.get(base_url, params)

    if response.status_code == 200:
        data = response.json()
        return _parse_response(data)
    else:
        response.raise_for_status()

def _parse_response(data: dict) -> NyTimesResponse:
    return NyTimesResponse(**data)