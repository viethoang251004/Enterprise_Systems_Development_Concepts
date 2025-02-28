import os
import webbrowser
import requests
from urllib.parse import parse_qs

# Define GitHub's Client ID, Client Secret, Endpoints
CLIENT_ID = "Ov23ligKsdM95J3vo1fi"
CLIENT_SECRET = "996d8a6b3b7dd0023bd231db8598541a4dd1f530"
AUTH_ENDPOINT = f"https://github.com/login/oauth/authorize?response_type=code&client_id={CLIENT_ID}"
TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token"
USER_ENDPOINT = "https://api.github.com/user"

# Obtain authorization code
webbrowser.open(AUTH_ENDPOINT, new=2)
print(f"If the web browser is not opened, please use this Authorization URL: {AUTH_ENDPOINT}")
auth_code = input("Enter the auth code: ")

# Get access token by providing the obtained code
request = requests.post(TOKEN_ENDPOINT, data=dict(client_id=CLIENT_ID, client_secret=CLIENT_SECRET, code=auth_code,))
request = parse_qs(request.content.decode('utf-8'))
token = request['access_token'][0]

# Use the obtained access_token to retrieve user's information
user_data = requests.get(USER_ENDPOINT, headers=dict(AUTHORIZATION=f"token {token}")).json()

# Retrieve additional information
username = user_data.get("login")
name = user_data.get("name")
email = user_data.get("email")
company = user_data.get("company")
bio = user_data.get("bio")

print(f"GitHub Username: {username}")
print(f"Name: {name}")
print(f"Email: {email}")
print(f"Company: {company}")
print(f"Bio: {bio}")
