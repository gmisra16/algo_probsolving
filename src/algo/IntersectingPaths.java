package algo;

import java.util.*;

public class IntersectingPaths {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            HashMap<Integer,Set<Integer>> graph  = new HashMap<>();
            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                for (int j = 1; j < N; j++) {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    if (graph.containsKey(u)){
                        graph.get(u).add(v);
                    }else{
                        Set<Integer> value = new HashSet<>();
                        value.add(v);
                        graph.put(u,value);
                    }
                    if (graph.containsKey(v)){
                        graph.get(v).add(u);
                    }else{
                        Set<Integer> value = new HashSet<>();
                        value.add(u);
                        graph.put(v,value);
                    }
                }
                int Q = scanner.nextInt();
                for (int j = 0; j < Q; j++) {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    Set<Integer> visited = new HashSet<>();
                    dfs(graph,u,visited);
                }
            }
        }

    }
    static void dfs(HashMap<Integer,Set<Integer>> graph, int src, Set visited){
        visited.add(src);
        Iterator<Integer> neighbours =graph.get(src).iterator();
        while(neighbours.hasNext()){
            int node  = neighbours.next();
            if(!visited.contains(node)){
                dfs(graph,node,visited);
            }

        }

    }
}
