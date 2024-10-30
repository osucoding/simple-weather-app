from flask import Blueprint, jsonify, Response

blueprint = Blueprint(
    'nytimes_controller',
    __name__,
    url_prefix='/api/v0/ny-times'
)

@blueprint.route('/news', methods=['GET'])
def get_news():
    return jsonify({
        'message': 'hi'
    })