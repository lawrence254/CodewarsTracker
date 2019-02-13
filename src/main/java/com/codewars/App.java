package com.codewars;

import com.codewars.model.Codewars;
import com.codewars.model.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class App{
    //To Log all the Json Data That we are receiving
    static Logger logger = LoggerFactory.getLogger(App.class);

    public static Codewars processCodewars(Response response) {
        Codewars codewars = null;
        // Result result = null;
        try {
            String jsonData = response.body().string();
            logger.info("Details response: " + jsonData);

            if (response.isSuccessful()) {
                JSONObject responseJson = new JSONObject(jsonData);
                Gson gson = new GsonBuilder().create();
                codewars = gson.fromJson(responseJson.toString(), Codewars.class);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return codewars;
    }

    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);



        //Creating a New OkHttp Request
        OkHttpClient client = new OkHttpClient();

        //Debugging Screen
        enableDebugScreen();

        staticFileLocation("/public");

        //layout template
        String layout = "templates/layout.vtl";

        ArrayList usernames = new ArrayList();
        //INDEX PAGE // Top rated
        get("/", (req, res) -> {
            String user;
            String acc;
            String url;
            Request request = null;
            List<Codewars> usersList = new ArrayList<>();
            Map<String, Object> model = new HashMap<>();
            HttpUrl.Builder codeBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();

            try {

                FileReader fileReader = new FileReader("/home/master/Documents/TMProjects/CodeClass/src/main/java/com/codewars/names.json");
                JSONTokener jTokener = new JSONTokener(fileReader);
                JSONArray users = new JSONArray(jTokener);
                for (int i = 0; i < users.length(); i++) {
                    JSONObject userObj = users.getJSONObject(i);
                    user = userObj.getString("username");
                    usernames.add(user);
//                 System.out.println(user);
                }
            } catch (Exception e) {
                logger.error(String.valueOf(e));
            }

//                 Iterator it = usernames.iterator();
            for (int j=0;j<usernames.size();j++){
                Object userO = usernames.get(j);
                acc =(String)userO;
//                codeBuilder.setPathSegment(0, acc);
                url = String.format(Constants.BASE_URL, acc);
                logger.info("Base url is: " + url);

                request = new Request.Builder()
                        .url(url)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    Codewars result = processCodewars(response);
                    if (result != null) {
                        usersList.add(result);

                    }
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
//
            model.put("users", usersList);
            model.put("template", "templates/index.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
        });
    }
}
