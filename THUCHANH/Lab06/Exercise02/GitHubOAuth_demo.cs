using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Collections.Generic;

class GitHubOAuth
{
    private static readonly string CLIENT_ID = "Ov23ligKsdM95J3vo1fi";
    private static readonly string CLIENT_SECRET = "996d8a6b3b7dd0023bd231db8598541a4dd1f530";
    private static readonly string AUTH_ENDPOINT = $"https://github.com/login/oauth/authorize?response_type=code&client_id={CLIENT_ID}";
    private static readonly string TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token";
    private static readonly string USER_ENDPOINT = "https://api.github.com/user";

    static async Task Main(string[] args)
    {
        // Open authorization page
        Console.WriteLine("Opening browser for GitHub authorization...");
        System.Diagnostics.Process.Start(new System.Diagnostics.ProcessStartInfo
        {
            FileName = AUTH_ENDPOINT,
            UseShellExecute = true
        });

        // Get authorization code from user
        Console.Write("Enter the auth code: ");
        string authCode = Console.ReadLine();

        // Get access token
        string accessToken = await GetAccessToken(authCode);
        if (accessToken != null)
        {
            await FetchUserData(accessToken);
        }
    }

    private static async Task<string> GetAccessToken(string authCode)
    {
        using (var client = new HttpClient())
        {
            var content = new FormUrlEncodedContent(new[]
            {
                new KeyValuePair<string, string>("client_id", CLIENT_ID),
                new KeyValuePair<string, string>("client_secret", CLIENT_SECRET),
                new KeyValuePair<string, string>("code", authCode)
            });

            var response = await client.PostAsync(TOKEN_ENDPOINT, content);
            var responseString = await response.Content.ReadAsStringAsync();

            // Extract access token from the response
            var query = System.Web.HttpUtility.ParseQueryString(responseString);
            return query["access_token"];
        }
    }

    private static async Task FetchUserData(string token)
    {
        using (var client = new HttpClient())
        {
            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);
            client.DefaultRequestHeaders.UserAgent.Add(new ProductInfoHeaderValue("AppName", "1.0")); // Required by GitHub API

            var response = await client.GetAsync(USER_ENDPOINT);
            var userData = await response.Content.ReadAsStringAsync();

            Console.WriteLine("User Data: " + userData);
        }
    }
}
