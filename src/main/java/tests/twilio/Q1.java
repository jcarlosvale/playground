package tests.twilio;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Q1 {

    public static int avgRotorSpeed(String statusQuery, int parentId) {
        if (statusQuery == null) return 0;
        else {
            try {
                String content = getResults(statusQuery, 1);
                return getAvgRotorSpeed(content, statusQuery, parentId);
            } catch (Exception e) {
                return 0;
            }
        }
    }

    private static int getAvgRotorSpeed(String content, String statusQuery, int parentId)
            throws ScriptException, IOException {
        int sum = 0, total = 0;
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        Object result = engine.eval("Java.asJSONCompatible(" +content + ")");
        Map contents = (Map) result;

        int pages = (int) contents.get("total_pages");
        int currentPage = Integer.valueOf(contents.get("page").toString());

        while(currentPage <= pages) {
            if(currentPage != 1) {
                content = getResults(statusQuery, currentPage);
                result = engine.eval("Java.asJSONCompatible(" +content + ")");
                contents = (Map) result;
            }
            List data = (List) contents.get("data");
            for(Object device: data) {
                Map deviceMap = (Map) device;
                if (deviceMap.get("parent") != null) {
                    Map parent = (Map) deviceMap.get("parent");
                    if ((int)parent.get("id") == parentId) {
                        Map operationParams = (Map) deviceMap.get("operatingParams");
                        if (operationParams != null) {
                            sum += (int) operationParams.get("rotorSpeed");
                            total++;
                        }
                    }
                }
            }
            currentPage++;
        }
        if (total == 0) return 0;
        return sum / total;
    }

    private static String getResults(String statusQuery, int page) throws IOException, ScriptException {
        final String urlString = "https://jsonmock.hackerrank.com/api/iot_devices/search?";
        String filterStatus = "status=" + statusQuery;
        String filterPage = "&page=" + page;
        URL url = new URL(urlString + filterStatus + filterPage);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output = br.readLine();
        conn.disconnect();
        return output;
    }

    public static void main(String[] args) {
        System.out.println(avgRotorSpeed("STOP", 2));
    }
}
