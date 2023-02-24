import java.util.ArrayList;
import java.util.List;

public class Three {
    Node root;

    public boolean exist(int value){
        if(root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }
    private Node find(Node node, int value){ // обход в глубину
        if(node.value == value){
            return node;
        }
        else{
            for (Node child: node.children) {
                Node result = find(child, value);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }

    private Node find2(int value){  // обход в ширину
        List<Node> Line = new ArrayList<>();
        Line.add(root);
        while(Line.size() > 0){
            List<Node> nextLine = new ArrayList<>();
            for (Node node : Line) {
                if(node.value == value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            Line = nextLine;
        }
        return null;
    }
    public class Node {
        int value;
        List<Node> children;
    }
}
