import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gameOfStones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */

    public static String gameOfStones(int n) {
        // Write your code here
        if (n == 0) return "Second";

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;

        for (int i = 0; i <= n; i++) {
            dp[i] = false;

            if (i >= 2 && !dp[i - 2]) dp[i] = true;
            if (i >= 3 && !dp[i - 3]) dp[i] = true;
            if (i >= 5 && !dp[i - 5]) dp[i] = true;
        }
        return dp[n] ? "First" : "Second";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.gameOfStones(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
