package IO.Search;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    private static class Node {
        public Node (char ch) {
            this.ch = ch;
        }
        private boolean isEnd;
        private char ch;
        private HashMap<Character , Node> nodes = new HashMap<>();

        public boolean hasChild (char ch) {
            return nodes.containsKey(ch);
        }

        public void addChild (char ch) {
            nodes.put(ch, new Node(ch));
        }

        public Node getChild (char ch) {
            return nodes.get(ch);
        }

        public Node[] getAllChildren () {
            return nodes.values().toArray(new Node[0]);
        }

        public void removeChild (char ch) {
            nodes.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public ArrayList<String> autoComplete (String string) {
        if (string == null)
            throw new IllegalStateException();

        ArrayList <String> arrayList = new ArrayList<>();
        autoComplete(root , string , "" , 0 , arrayList);
        return arrayList;
    }

    private void autoComplete (Node root , String string , String newString , int index , ArrayList<String> arrayList) {
        if (root == null)
            return;

        if (root.isEnd)
            arrayList.add(newString);

        if (root.getAllChildren().length == 0)
            return;

        if (index < string.length()) {
            char ch = string.charAt(index);
            autoComplete(root.getChild(ch) , string , newString + ch , index + 1 , arrayList);
        }
        else {
            for (Node node : root.getAllChildren()) {
                char ch = node.ch;
                autoComplete(root.getChild(ch) , string , newString + ch , index + 1 , arrayList);
            }
        }
    }

    public void add (String string) {
        char [] arr = string.toCharArray();
        var current = root;

        for (char c : arr) {
            if (!current.hasChild(c))
                current.addChild(c);

            current = current.getChild(c);
        }
        current.isEnd = true;
    }
}
