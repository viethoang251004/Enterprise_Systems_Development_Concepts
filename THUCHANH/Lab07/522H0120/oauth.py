# Filename: oauth.py
import os
from flask_dance. contrib. github import make_github_blueprint

github_blueprint = make_github_blueprint(
client_id=os.getenv('GITHUB_CLIENT_ID'),
client_secret=os.getenv('GITHUB_CLIENT_SECRET')

)