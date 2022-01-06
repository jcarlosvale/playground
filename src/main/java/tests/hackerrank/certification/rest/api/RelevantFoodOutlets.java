package tests.hackerrank.certification.rest.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RelevantFoodOutlets {

    private static String URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<page>";

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) {

        final List<String> relevantFoodOutlets = new ArrayList<>();

        try {

            int page = 1;
            int totalPage = 1;

            while(page <= totalPage) {
                String json = getFromUrl(URL.replace("<city>", city).replace("<page>", "" + page));
                JsonObject jsonObject =  new Gson().fromJson(json, JsonObject.class);
                totalPage = jsonObject.get("total_pages").getAsInt();
                JsonArray jsonArray = jsonObject.get("data").getAsJsonArray();
                jsonArray.forEach(jsonElement -> {
                    JsonObject arrayElement = jsonElement.getAsJsonObject();
                    String outletName = arrayElement.get("name").getAsString();
                    int estimatedCost = arrayElement.get("estimated_cost").getAsInt();
                    if (estimatedCost <= maxCost) relevantFoodOutlets.add(outletName);
                });
                page++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return relevantFoodOutlets;
    }

    private static String getFromUrl(String uri) throws IOException {
        java.net.URL url = new URL(uri);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = null;
        try {
            inputStream = connection.getInputStream();
        } catch (IOException e) {
            InputStream error = ((HttpURLConnection) connection).getErrorStream();
            System.out.println(error);
        }

        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        System.out.println(getRelevantFoodOutlets("Denver", 50));
    }
}
