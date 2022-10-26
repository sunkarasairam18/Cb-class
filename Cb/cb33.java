package Cb;

public class cb33 {
    public static void main(String... args){
        //https://leetcode.com/problems/sudoku-solver/
        int[][] mat = {{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,0,0,0}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        maze(0,0,mat,visited,"");  // All possible ways to reach bottom right corner,start from left corner.
    }
    static void maze(int r,int c,int[][] mat,boolean[][] visited,String path){
        if(r<0 || r == mat.length || c<0 || c == mat[0].length || mat[r][c] == 1 || visited[r][c]) return;

        if(r == mat.length-1 && c == mat[0].length-1){
            System.out.println(path);
            return;
        }
        visited[r][c] = true;
        maze(r+1,c,mat,visited,path+"D");  // we keep goind down till limit,after limit it goes to next function call Up
        maze(r-1,c,mat,visited,path+"U"); // we visit again to which we came back but we shouldn't visit that so we keeping visited[r][c] as true so it shouldn't be visited again and again
        maze(r,c+1,mat,visited,path+"R");
        maze(r,c-1,mat,visited,path+"L");
        visited[r][c] = false; // once we visited r,c and completed exploring all 4 paths recursion call completes on r,c.
                                // we make it unvisited so r,c be visited from other direction.

    }
}
