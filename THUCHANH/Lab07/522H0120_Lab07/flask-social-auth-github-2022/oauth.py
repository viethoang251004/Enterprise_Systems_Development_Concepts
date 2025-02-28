# Filename: oauth.py
import os
from flask_login import current_user, login_user
from flask_dance.consumer import oauth_authorized
from flask_dance.contrib.github import github, make_github_blueprint
from flask_dance.consumer.storage.sqla import SQLAlchemyStorage
# sqlalchemy < 1.4: from sqlalchemy.orm.exc import NoResultFound
from sqlalchemy.exc import NoResultFound
from app import db
from models import OAuth, User


github_blueprint = make_github_blueprint(
    client_id=os.getenv('Ov23liqkQSDSACVkiqFJ'),
    client_secret=os.getenv('27385bf6856687449ede1eb1bb034e6f7d4bd86c'),
    storage=SQLAlchemyStorage(OAuth, db.session, user=current_user, user_required=False)
)


@oauth_authorized.connect_via(github_blueprint)
def github_logged_in(blueprint, token):
    info = github.get("/user")
    if info.ok:
        account_info = info.json()
        username = account_info["login"]

        query = User.query.filter_by(username=username)
        try:
            user = query.one()
        except NoResultFound:
            user = User(username=username)
            db.session.add(user)
            db.session.commit()
        login_user(user)
