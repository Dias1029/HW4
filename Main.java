public class Main {


    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Nur-Sultan", 3.9);
        graph.addEdge("Nur-Sultan", "Taraz", 3.5);
        graph.addEdge("Taraz", "Kyzylorda", 5.4);

        System.out.println("Dijkstra algorithm:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

        Graph<String> graphNew = new Graph<>(true);
        graphNew.addEdge("Almaty", "Astana");
        graphNew.addEdge("Almaty", "Shymkent");
        graphNew.addEdge("Shymkent", "Nur-Sultan");
        graphNew.addEdge("Nur-Sultan", "Taraz");
        graphNew.addEdge("Taraz", "Oskemen");
        graphNew.addEdge("Oskemen", "Atyrau");

        System.out.println("\n--------------------------------");

        System.out.println("DFS Traversal:");
        Search<String> dfs = new DepthFirstSearch<>(graphNew, "Almaty");
        graphNew.dfs("Atyrau");

        System.out.println("\n--------------------------------");

        System.out.print("BFS Traversal:" + '\n');
        Search<String> bfs = new BreadthFirstSearch<>(graphNew, "Almaty");
        graphNew.bfs("Atyrau");

    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
