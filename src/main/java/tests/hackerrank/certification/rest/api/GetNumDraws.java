package tests.hackerrank.certification.rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GetNumDraws {

    public static int getNumDraws(int year) {

        int totalPage = 1;
        int page = 0;
        int score1 = -1;
        int score2 = -1;
        int count = 0;

        try {

        while(page <= totalPage) {
            String uri = page > 0 ? "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=" + page :
                    "https://jsonmock.hackerrank.com/api/football_matches?year=" + year;

            URL url = new URL(uri);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();

            String text = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            String[] tokens = text.split(",");


            for(String token : tokens) {
                if(token.contains("\"total_pages\":")) {
                    totalPage = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", ""));
                }

                if(token.contains("\"page\":")) {
                    page = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", ""));
                }
                if(token.contains("\"team1goals\"")) {
                    score1 = Integer.parseInt(token.split(":")[1].replace("\"", "").replace("}", "").replace("]", ""));
                }
                if(token.contains("\"team2goals\":")) {
                    score2 = Integer.parseInt(token.split(":")[1].replace("\"", "").replace("}", "").replace("]", ""));
                    if(score1 == score2) count++;
                }
            }
            page++;
        }


        return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        System.out.println(getNumDraws(2011));
    }

}
