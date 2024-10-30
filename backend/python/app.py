from flask import Flask

from controller.sample_controller import blueprint as sample_blueprint
from controller.nytimes_controller import blueprint as nytimes_blueprint

app = Flask(__name__)

def setup_flask():
    # register sample_controller
    app.register_blueprint(sample_blueprint)
    # register nytimes_controller
    app.register_blueprint(nytimes_blueprint)

if __name__ == '__main__':
    setup_flask()

    app.run(port=8081)