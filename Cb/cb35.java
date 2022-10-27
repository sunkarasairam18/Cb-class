package Cb;

public class cb35 {
    public static void main(String... args){
        int[][] mazecir = {{0,1,0,0,1},{0,1,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        maze(0,0,5,5,"",mazecir);  // printing all possible paths right and down to right-bottom corner while 1's are obstacles.


        //https://leetcode.com/problems/word-search/
    }
    static void maze(int r,int c,int rl,int cl,String path,int[][] mazecir){
        if(r == rl-1 && c == cl-1){
            System.out.println(path);
            return;
        }
        if(r == rl || c == cl || mazecir[r][c] == 1) return;
        maze(r,c+1,rl,cl,path+"R",mazecir);
        maze(r+1,c,rl,cl,path+"D",mazecir);
    }
}
