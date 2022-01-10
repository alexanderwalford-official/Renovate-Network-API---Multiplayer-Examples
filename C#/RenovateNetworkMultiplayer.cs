using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;

// RenovateNetworkMultiplayer.cs
// Renovate Software LTD 2022
// Written by Alexander Walford

public class RenovateNetworkMultiplayer
{
    private static readonly HttpClient client = new HttpClient(); // the HTTP client object
    public async void SetPlayer(string apikey, string username, string lobby, string position, string rotation)
    {
        // in this method we're sending the player's data to the server
        var values = new Dictionary<string, string>
        {
            { "apikey", apikey },
            { "playerid", username },
            { "lobbyid", lobby },
            { "position", position },
            { "rotation", rotation }

        };
        var content = new FormUrlEncodedContent(values);
        var response = await client.PostAsync("https://renovatesoftware.com/API/setplayerdata/ ", content);
        var responseString = await response.Content.ReadAsStringAsync();
    }

    public async void SetGameObject(string apikey, string objectid, string lobby, string sparams)
    {
        // in this method we're sending game object data to the server
        var values = new Dictionary<string, string>
        {
            { "apikey", apikey },
            { "objectid", objectid },
            { "lobbyid", lobby },
            { "params", sparams },
        };
        var content = new FormUrlEncodedContent(values);
        var response = await client.PostAsync("https://renovatesoftware.com/API/setgameobjectdata/ ", content);
        var responseString = await response.Content.ReadAsStringAsync();
    }

    static public string GetPlayerList(string apikey, string lobbyid)
    {
        HttpWebRequest request = (HttpWebRequest)WebRequest.Create("https://renovatesoftware.com/API/GET/getplayers/" + apikey + "/" + lobbyid + "/");
        request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;

        using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
        using (Stream stream = response.GetResponseStream())
        using (StreamReader reader = new StreamReader(stream))
        {
            string data = reader.ReadToEnd();
            return data;
        }
    }

    static public string GetPlayerData(string apikey, string playerID)
    {
        HttpWebRequest request = (HttpWebRequest)WebRequest.Create("https://renovatesoftware.com/API/GET/getplayerdata/" + apikey + "/" + playerID + "/");
        request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;

        using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
        using (Stream stream = response.GetResponseStream())
        using (StreamReader reader = new StreamReader(stream))
        {
            string data = reader.ReadToEnd();
            return data;
        }
    }

    static public string GetGameObject(string apikey, string lobbyid, string objectid)
    {
        HttpWebRequest request = (HttpWebRequest)WebRequest.Create("https://renovatesoftware.com/API/GET/getgameobjectdata/" + apikey + "/" + lobbyid + "/" + objectid + "/");
        request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;

        using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
        using (Stream stream = response.GetResponseStream())
        using (StreamReader reader = new StreamReader(stream))
        {
            string data = reader.ReadToEnd();
            return data;
        }
    }
}