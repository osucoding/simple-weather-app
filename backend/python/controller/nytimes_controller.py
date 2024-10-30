from flask import Blueprint, Response, request
import service.nytimes_service as nytimes_service

blueprint = Blueprint(
    'nytimes_controller',
    __name__,
    url_prefix='/api/v0/ny-times'
)

@blueprint.route('/news', methods=['GET'])
def get_news():
    section_value = request.args.get('sectionValue')
    response = nytimes_service.get_news(section_value)
    return Response(response.model_dump_json(), status=200, mimetype='application/json')
