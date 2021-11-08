import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

// RenovateNetworkMultiplayer.java
// Renovate Software LTD 2021
// Written by Alexander Walford

public class RenovateNetwork {
	
	public static byte[] SetPlayer (String apikey, String username, String lobby, String position, String rotation) throws IOException {
        URL url = new URL("https://renovatesoftware.com/API/setplayerdata/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // set the method to POST
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();

        arguments.put("apikey", apikey); // provide the API key
        arguments.put("playerid", username); // set the player id
        arguments.put("lobbyid", lobby); // set the lobby id
        arguments.put("position", position); // set the player position
        arguments.put("rotation", rotation); // set the player rotation

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            // handle output
            return out;
        }
    }

    public static byte[] GetPlayer (String apikey, String username) throws IOException {
        URL url = new URL("https://renovatesoftware.com/API/getplayerdata/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // set the method to POST
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();

        arguments.put("apikey", apikey); // provide the API key
        arguments.put("playerid", username); // set the player id

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            // handle output
            return out;
        }
    }

    public static byte[] GetPlayerList (String apikey, String lobby) throws IOException {
        URL url = new URL("https://renovatesoftware.com/API/getplayerlist/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // set the method to POST
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();

        arguments.put("apikey", apikey); // provide the API key
        arguments.put("lobbyid", lobby); // set the lobby id

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            // handle output
            return out;
        }
    }
	
	public static byte[] SetGameObject (String apikey, String objectid, String lobby, String params) throws IOException {
        URL url = new URL("https://renovatesoftware.com/API/setgameobjectdata/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // set the method to POST
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();

        arguments.put("apikey", apikey); // provide the API key
        arguments.put("objectid", objectid); // set the object id
        arguments.put("lobbyid", lobby); // set the lobby id
        arguments.put("params", params); // set the player position

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            // handle output
            return out;
        }
    }
	
	public static byte[] GetGameObject (String apikey, String objectid, String lobby) throws IOException {
        URL url = new URL("https://renovatesoftware.com/API/getgameobjectdata/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // set the method to POST
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();

        arguments.put("apikey", apikey); // provide the API key
        arguments.put("objectid", objectid); // set the object id
        arguments.put("lobbyid", lobby); // set the lobby id

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            // handle output
            return out;
        }
    }
}