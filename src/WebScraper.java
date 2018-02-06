import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void wordCount(String text) {
        char[] letters = text.toCharArray();
        char previous = letters[0];
        int count = 0;
        for (int i = 1; i < letters.length; i++) {
            if (previous != ' ') {
                if (letters[i] == ' ' || letters[i] == '\n') {
                    count++;
                }
            }
            previous = letters[i];

        }
        System.out.println(count);
        return;

    }

    public static void main(String[] unused) {
        wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        wordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        wordCount(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
    }
}
