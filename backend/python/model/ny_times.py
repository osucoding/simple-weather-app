from typing import List

from pydantic import BaseModel, Field


class ResultsItem(BaseModel):
    abstract_title: str = Field(alias='abstract', title='abstract')
    url: str
    byline: str

    class Config:
        extra = 'ignore'

class NyTimesResponse(BaseModel):
    results: List[ResultsItem]

    class Config:
        extra = 'ignore'