package tests.leetcode.challenge30days.march2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3673/
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm
should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded
to the original URL.
 */
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
public class Encode_And_Decode_TinyURL {

    private final Map<String, String> mapUrls = new HashMap<>();
    private final static String PREFIX = "http:/tinyurl.com/";
    private final Random r = new Random();


    private String getRandomChar(boolean isNumeric) {
        if (isNumeric) {
            return String.valueOf(r.nextInt(10));
        } else {
            int letter = 'a' + r.nextInt(27);
            char c = (char) letter;
            return String.valueOf(c);
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = generateUrl();
        while(mapUrls.containsKey(shortUrl)) {
            shortUrl = generateUrl();
        }
        mapUrls.put(shortUrl, longUrl);
        return shortUrl;
    }

    private String generateUrl() {
        return  getRandomChar(true) +
                getRandomChar(false) +
                getRandomChar(true) +
                getRandomChar(false) +
                getRandomChar(false).toUpperCase() +
                getRandomChar(false).toUpperCase();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapUrls.get(shortUrl);
    }

    public static void main(String[] args) {
        Encode_And_Decode_TinyURL codec = new Encode_And_Decode_TinyURL();
        System.out.println(codec.decode(codec.encode("https:/leetcode.com/problems/design-tinyurl")));
    }
}
