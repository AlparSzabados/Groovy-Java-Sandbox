package szabados.alpar.exercises.leetCodeSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Codec {
    private Map<String, String> decoded = new HashMap<>();

    public String encode(String longUrl) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String shortUrl = "http://tinyurl.com/";
        for (int i = 0; i < 6; i++) {
            final int random = (int) (Math.random() * chars.length());
            shortUrl += chars.charAt(random);
        }

        decoded.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return decoded.get(shortUrl);
    }
}
