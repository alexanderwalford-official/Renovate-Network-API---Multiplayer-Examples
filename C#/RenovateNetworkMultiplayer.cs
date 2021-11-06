using System;
using System.Collections.Generic;
using System.Net;

// RenovateNetworkMultiplayer.cs
// Renovate Software LTD 2020
// Written by Alexander Walford

class RenovateNetwork
{
	private static readonly HttpClient client = new HttpClient(); // the HTTP client object
	
    public async void SetPlayer(string apikey, string username, string lobby, string position, string rotation)
    {
		// in this method we're sending the player's data to the server
		var values = new Dictionary<string, string>
        {
            { "apikey", apikey },
            { "userid", username },
			{ "lobbyid", lobby },
			{ "position", position },
			{ "rotation", rotation }
			
        };
        var content = new FormUrlEncodedContent(values);
        var response = await client.PostAsync("https://renovatesoftware.com/API/setplayerdata/ ", content);
        var responseString = await response.Content.ReadAsStringAsync();
        return responseString;
	}
	
	public async void GetPlayer(string apikey, string username)
    {
		// in this method we're getting the player's data from the server
		var values = new Dictionary<string, string>
        {
            { "apikey", apikey },
            { "userid", username }
        };
        var content = new FormUrlEncodedContent(values);
        var response = await client.PostAsync("https://renovatesoftware.com/API/getplayerdata/ ", content);
        var responseString = await response.Content.ReadAsStringAsync();
        return responseString;
	}		
	
	public async void GetPlayerList(string apikey, string lobby)
    {
		// in this method we're getting the current lobby's player list
		var values = new Dictionary<string, string>
        {
            { "apikey", apikey },
            { "lobbyid", lobby }
        };
        var content = new FormUrlEncodedContent(values);
        var response = await client.PostAsync("https://renovatesoftware.com/API/getplayerlist/ ", content);
        var responseString = await response.Content.ReadAsStringAsync();
        return responseString;
	}	
}