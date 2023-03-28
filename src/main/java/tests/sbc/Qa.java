package tests.sbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Qa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha = br.readLine();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(linha);
        int [] counter = new int[n+1];
        int [][] request = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            var values= br.readLine().split(" ");
            var req1 = Integer.parseInt(values[0]);
            var req2 = Integer.parseInt(values[1]);
            counter[req1]++;
            counter[req2]++;
            request[i][0] = req1;
            request[i][1] = req2;
        }

        for (int i = 1; i <= n; i++) {

            if ((counter[request[i][0]] < 2) || (counter[request[i][1]] < 2)) {
                sb.append("N");
            } else {
                sb.append("Y");
            }
        }

        System.out.println(sb);
    }
}
