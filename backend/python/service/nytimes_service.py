
from model.ny_times import NyTimesResponse
import client.nytimes_client as client


def get_news(section_value: str) -> NyTimesResponse:
    return client.get_news(section_value)