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

        int count = 0;

        try {

            for (int i = 0; i <= 10 ; i++) {

                String uri = "https://jsonmock.hackerrank.com/api/football_matches?year="+year+"&team1goals="+i+"&team2goals="+i+"&page=1";

                String text = getFromUrl(uri);

                String[] tokens = text.split(",");


                for(String token : tokens) {
                    if(token.contains("total\":")) {
                        count += Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", ""));
                        break;
                    }
                }
            }

            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getWinnerTotalGoals(String competition, int year) {
        int count = 0;

        try {

            int page = 0;
            int totalPage = 1;
            int score1=0;
            int score2=0;

            competition = competition.replace(" ", "%20");
            String uri = "https://jsonmock.hackerrank.com/api/football_matches?year="+year+"&competition="+competition;

            while(page <= totalPage) {
                String text = page == 0 ? getFromUrl(uri) : getFromUrl(uri+"&page="+page);

                String[] tokens = text.split(",");

                for(String token : tokens) {
                    if(token.contains("\"page\":")) {
                        page = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", ""));
                    }

                    if(token.contains("\"total_pages\":")) {
                        totalPage = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", ""));
                    }
                    if(token.contains("\"team1goals\":")) {
                        score1 = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", "").replace("\"", "").trim());
                    }
                    if(token.contains("\"team2goals\":")) {
                        score2 = Integer.parseInt(token.split(":")[1].replace("}", "").replace("]", "").replace("\"", "").trim());
                        if(score1 != score2) count+= Math.max(score1, score2);
                    }
                }
                page++;
            }
            return count;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    private static String getFromUrl(String uri) throws IOException {
        URL url = new URL(uri);

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

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        //System.out.println(getNumDraws(2011));
        System.out.println(getWinnerTotalGoals("UEFA Champions League", 2011)); //28
    }

}
