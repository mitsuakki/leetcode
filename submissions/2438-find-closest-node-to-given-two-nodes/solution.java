class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

        int min = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < min) {
                    min = maxDist;
                    result = i;
                } else if (maxDist == min) {
                    result = Math.min(result, i);
                }
            }
        }

        return result;
    }

    public int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] distances = new int[n];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int next = edges[node];
            if (next != -1 && distances[next] == -1) {
                distances[next] = distances[node] + 1;
                queue.add(next);
            }
        }

        return distances;
    }
}

