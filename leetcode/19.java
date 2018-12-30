import java.util.*;
// 133. Clone Graph
// Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. 
// There is an edge between the given node and each of the nodes in its neighbors.


// bfs实现图的遍历，通过Map生成<origin,copy>内容，在修改neighbors
public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> ans = new HashMap<>();
        LinkedList<UndirectedGraphNode> bfs = new LinkedList<UndirectedGraphNode>();
        bfs.add(node);

        while (!bfs.isEmpty()) {
            UndirectedGraphNode n = bfs.pollFirst();
            ans.putIfAbsent(n, new UndirectedGraphNode(n.label));
            for (UndirectedGraphNode var : n.neighbors) {
                if (!ans.containsKey(var)) {
                    bfs.add(var);
                }
            }
        }

        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> var : ans.entrySet()) {
            UndirectedGraphNode origin = var.getKey();
            UndirectedGraphNode copy = var.getValue();
            List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode neighbor : origin.neighbors) {
                nodes.add(ans.get(neighbor));
            }
            copy.neighbors = nodes;
        }
        return ans.get(node);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String[] test = in.split("#");
            Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
            for (String var : test) {
                int[] labels = Arrays.asList(var.split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
                for (int label : labels) {
                    nodes.putIfAbsent(label, new UndirectedGraphNode(label));
                }
                UndirectedGraphNode p = nodes.get(labels[0]);
                List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
                for (int i = 1; i < labels.length; i++) {
                    neighbors.add(nodes.get(labels[i]));
                }
                p.neighbors = neighbors;
            }
            log(nodes.get(0));
            UndirectedGraphNode ans = s.cloneGraph(nodes.get(0));
            log(ans);
        }
    }

    public static void log(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> visit = new HashSet<>();
        LinkedList<UndirectedGraphNode> bfs = new LinkedList<UndirectedGraphNode>();
        bfs.add(node);
        while (!bfs.isEmpty()) {
            UndirectedGraphNode n = bfs.pollFirst();
            if (n == null)
                continue;
            if (!visit.contains(n)) {
                System.out.print(n.label + " ");
                visit.add(n);
            }
            for (UndirectedGraphNode var : n.neighbors) {
                if (!visit.contains(var)) {
                    bfs.add(var);
                }
            }
        }
        System.out.println();
    }

}