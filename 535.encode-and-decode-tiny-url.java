import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

// @lc code=start
interface KGS {
    public String genKey(Map<String, String> idx);
}

class KGS0 implements KGS {
    public String genKey(Map<String, String> idx) {
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = "";
        while (idx.containsKey(key)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                char c = charSet.charAt((int) (Math.random() % charSet.length()));
                sb.append(c);
            }
            key = sb.toString();
        }
        return key;
    }
}

class Codec {
    Map<String, String> idx = new HashMap<>();
    Map<String, String> rev = new HashMap<>();
    final static String host = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (idx.containsKey(longUrl)) {
            return idx.get(longUrl);
        }
        KGS kgs = new KGS0();
        String key = kgs.genKey(idx);
        idx.put(longUrl, key);
        rev.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return rev.get(shortUrl.replace(host, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end
