// RenovateNetworkMultiplayer.js
// Renovate Software LTD 2021
// Written by Alexander Walford

function SetPlayer(apikey, username, lobby, position, rotation) {
var url = "https://renovatesoftware.com/API/setplayerdata/";

var xhr = new XMLHttpRequest();
xhr.open("POST", url);

xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.onreadystatechange = function () {
   if (xhr.readyState === 4) {
      console.log("SERVER: " + xhr.status);
   }};

var data = "apikey=" + apikey + "&playerid=" + username + "&lobbyid=" + lobby + "&position=" + position + "&rotation=" + rotation;

xhr.send(data);
}

function GetPlayer(apikey, username) {
var url = "https://renovatesoftware.com/API/getplayerdata/";

var xhr = new XMLHttpRequest();
xhr.open("POST", url);

xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.onreadystatechange = function () {
   if (xhr.readyState === 4) {
      console.log("SERVER: " + xhr.status);
	  document.getElementById(username + "_datatag").innerHTML = xhr.responseText;
   }};

var data = "apikey=" + apikey + "&playerid=\"" + username + "\"";

xhr.send(data);
}

function GetPlayerList(apikey, lobby) {
var url = "https://renovatesoftware.com/API/getplayerlist/";

var xhr = new XMLHttpRequest();
xhr.open("POST", url);

xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.onreadystatechange = function () {
   if (xhr.readyState === 4) {
      console.log("SERVER: " + xhr.status);
	  document.getElementById("lobby_datatag").innerHTML = xhr.responseText;
   }};

var data = "apikey=" + apikey + "&lobbyid=\"" + lobby + "\"";

xhr.send(data);
}

function SetObject(apikey, objectid, lobby, params) {
var url = "https://renovatesoftware.com/API/setgameobjectdata/";

var xhr = new XMLHttpRequest();
xhr.open("POST", url);

xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.onreadystatechange = function () {
   if (xhr.readyState === 4) {
      console.log("SERVER: " + xhr.status);
   }};

var data = "apikey=" + apikey + "&objectid=" + username + "&lobbyid=" + lobby + "&params=" + params;

xhr.send(data);
}

function GetObject(apikey, objectid, lobby) {
var url = "https://renovatesoftware.com/API/getgameobjectdata/";

var xhr = new XMLHttpRequest();
xhr.open("POST", url);

xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.onreadystatechange = function () {
   if (xhr.readyState === 4) {
      console.log("SERVER: " + xhr.status);
   }};

var data = "apikey=" + apikey + "&objectid=" + username + "&lobbyid=" + lobby;

xhr.send(data);
}