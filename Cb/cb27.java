package Cb;

public class cb27 {

    public static void main(String... args){
//        toh(6,"A","C","B");
//        geneparen(3,3,"");
        maze(1,1,3,3,"");
    }
    static void toh(int c,String start,String dest,String helper){
        if(c == 0) return;
        toh(c-1,start,helper,dest);
        System.out.println(" Move "+c+" from "+start+" to "+dest);
        toh(c-1,helper,dest,start);

    }
    static void geneparen(int open,int close,String s){
        if(open == 0 && close == 0){
            System.out.println(s);
            return;
        }
        if(open>close) return;
        if(open>0) geneparen(open-1,close,s+"(");
        if(close>0) geneparen(open,close-1,s+")");
    }
    static int climbstairs(int cur,int dest){
        if(cur == dest) return 1;
        if(cur>dest) return 0;
        return climbstairs(cur+1,dest)+climbstairs(cur+2,dest);
    }
    static void maze(int x,int y,int m,int n,String path){
        if(x == m && y == n){
            System.out.println(path);
            return;
        }
        if(x>m || y>n) return;
        maze(x+1,y,m,n,path+"R");
        maze(x,y+1,m,n,path+"D");

    }
}
