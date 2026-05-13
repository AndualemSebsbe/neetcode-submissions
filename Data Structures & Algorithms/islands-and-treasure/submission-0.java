class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int inf = 2147483647;
        int[][] dirs = {{0,1}, {0,-1}, {-1,0},{1,0}};

        Queue<int[]> queue = new LinkedList();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        int len = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();

                for(int[] dir : dirs){
                    int newR = cur[0] + dir[0];
                    int newC = cur[1] + dir[1];

                    if(newR < 0 || newR == m || newC < 0 || newC == n || grid[newR][newC] != inf)
                        continue;
                    
                    grid[newR][newC] = len;
                    queue.add(new int[]{newR, newC});
                }
            }

            len += 1;
        }
    }
}
