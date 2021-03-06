package com.graph;

import java.util.*;

public class graphBFS {

    private LinkedList<LinkedList> adj;

    graphBFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    public void addEle(int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void bfs(int source, int destination) {

        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        int parent[] = new int[adj.size()];

        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == destination) break;

            for (Object neigh : adj.get(cur)) {

                if (!visited[(int) neigh]) {
                    queue.add((Integer) neigh);
                    visited[(int) neigh] = true;
                    parent[(int) neigh] = cur;
                }
            }
        }

        int cur = destination;
        int dis = 0;

        while (parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            dis++;
        }
        System.out.print(source);

        System.out.println("The minimum path distance is " + dis);
    }


    public static void main(String[] args) {

        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        graphBFS graph = new graphBFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        System.out.println("Enter source and destination for bfs ");
        int s = sc.nextInt();
        int d = sc.nextInt();
        graph.bfs(s, d);
    }
}
