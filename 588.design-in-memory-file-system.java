import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start
class Node {
    String name;
    boolean isFile;
    StringBuilder content;
    Map<String, Node> children;

    public Node(String name) {
        this.content = new StringBuilder();
        this.name = name;
        this.children = new TreeMap<String, Node>();
    }
}

class FileSystem {

    Node root;

    public FileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {

        Node nd = traverse(path);

        List<String> res = new ArrayList<String>();

        if (nd.isFile) {
            res.add(nd.name);
        } else {
            for (String child : nd.children.keySet()) {
                res.add(child);
            }
        }

        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {

        Node n = traverse(filePath);
        n.isFile = true;
        n.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node n = traverse(filePath);
        return n.content.toString();
    }

    private Node traverse(String filePath) {
        String[] arr = filePath.split("/");
        Node curr = root;
        // start from index 1 as 0th element is ""
        for (int i = 1; i < arr.length; i++) {
            if (!curr.children.containsKey(arr[i])) {
                Node n = new Node(arr[i]);
                curr.children.put(arr[i], n);
            }
            curr = curr.children.get(arr[i]);
        }
        return curr;
    }

}

/**
 * Your FileSystem object will be instantiated and called as such: FileSystem
 * obj = new FileSystem(); List<String> param_1 = obj.ls(path); obj.mkdir(path);
 * obj.addContentToFile(filePath,content); String param_4 =
 * obj.readContentFromFile(filePath);
 */
// @lc code=end
