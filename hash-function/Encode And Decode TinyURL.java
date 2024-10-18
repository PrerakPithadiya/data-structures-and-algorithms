
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class implements a URL shortening service similar to TinyURL. It
 * provides methods to encode a long URL into a short URL and decode it back.
 */
class Codec {

    // Map to store shortUrl -> longUrl mapping
    private final Map<String, String> urlMap = new HashMap<>();
    private final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String baseUrl = "http://tinyurl.com/";
    private final Random rand = new Random();
    private final int keyLength = 6;

    /**
     * Generates a random key for shortening the URL.
     *
     * @return A string of length 'keyLength' containing random characters.
     */
    private String generateKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < keyLength; i++) {
            key.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return key.toString();
    }

    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl The original long URL to be shortened.
     * @return The shortened URL.
     */
    public String encode(String longUrl) {
        String key = generateKey();

        // Ensure the key is unique
        while (urlMap.containsKey(baseUrl + key)) {
            key = generateKey();  // Generate a new key if collision occurs
        }

        String shortUrl = baseUrl + key;
        urlMap.put(shortUrl, longUrl);  // Store the mapping
        return shortUrl;
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl The shortened URL to be decoded.
     * @return The original long URL.
     */
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);  // Retrieve the original URL
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Test case 1: Basic encoding and decoding
        String longUrl1 = "https://www.example.com/very/long/url/path";
        String shortUrl1 = codec.encode(longUrl1);
        System.out.println("Test case 1:");
        System.out.println("Long URL: " + longUrl1);
        System.out.println("Short URL: " + shortUrl1);
        System.out.println("Decoded URL: " + codec.decode(shortUrl1));
        System.out.println("Test passed: " + longUrl1.equals(codec.decode(shortUrl1)));

        // Test case 2: Encoding the same URL twice
        String longUrl2 = "https://www.example.com/another/long/url";
        String shortUrl2a = codec.encode(longUrl2);
        String shortUrl2b = codec.encode(longUrl2);
        System.out.println("\nTest case 2:");
        System.out.println("Long URL: " + longUrl2);
        System.out.println("Short URL 1: " + shortUrl2a);
        System.out.println("Short URL 2: " + shortUrl2b);
        System.out.println("Decoded URL 1: " + codec.decode(shortUrl2a));
        System.out.println("Decoded URL 2: " + codec.decode(shortUrl2b));
        System.out.println("Test passed: " + (longUrl2.equals(codec.decode(shortUrl2a)) && longUrl2.equals(codec.decode(shortUrl2b))));

        // Test case 3: Decoding a non-existent short URL
        String nonExistentUrl = "http://tinyurl.com/abcdef";
        System.out.println("\nTest case 3:");
        System.out.println("Non-existent URL: " + nonExistentUrl);
        System.out.println("Decoded URL: " + codec.decode(nonExistentUrl));
        System.out.println("Test passed: " + (codec.decode(nonExistentUrl) == null));
    }
}
