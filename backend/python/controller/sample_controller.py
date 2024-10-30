
from flask import Blueprint, Response, request


blueprint = Blueprint(
    'sample_controller',
    __name__,
    url_prefix='/api/v0/sample'
)

@blueprint.route('/say-hi', methods=['GET'])
def say_hi():
    return Response('hello world', status=200, mimetype='application/json')

@blueprint.route('/say-my-name', methods=['GET'])
def say_my_name():
    name = request.args.get('name')
    if len(name) == 0:
        return Response('You must pass a name parameter', status=400, mimetype='application/json')
    return Response(f'hello {name}!', status=200, mimetype='application/json')