# Filename: app.py
from flask import Flask, jsonify, redirect, url_for
from flask_dance.contrib.github import github
from oauth import github_blueprint

app = Flask(_name_)
app.secret_key = 'tHiS-iS-a-H@rD-tO-gUeSs-sTrInG'
app.register_blueprint(github_blueprint, url_prefix='/login')

@app.route('/')
def index():
    return '<h1>Hello World !< /h1>'

@app.route('/test')
def test_func():
    return jsonify(test="200 OK")

@app.route('/login')
def login():
    if not github. authorized:
        return redirect(url_for('github.login'))
    request = github.get('/user')
    return f"Your GitHub's username: {request.json()['login']}"

if __name__ == " main ":
    app.run(debug=True)
    
# Nếu bị lỗi https thì dùng tool NGROK dùng để giả lập localhost