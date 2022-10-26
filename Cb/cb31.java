package Cb;

public class cb31 {
    public static void main(String... args){
        //        boolean[] visited = new boolean[4];
//        perm(2,"",visited); // selecting 2 boxes out of 4 order matters ,permutation.
//        comb(0,2,""); //Selecting 2 boxes out of 4 order not matters, combination.
    }

    static void perm(int i,String ans,boolean[] visited){
        if(i == 0){
            System.out.println(ans);
            return;
        }
        for(int j = 0;j<4;j++){
            if(!visited[j]){
                visited[j] = true;
                perm(i-1,ans+" b"+j,visited);
                visited[j] = false;
            }

        }
    }
    static void comb(int st,int i,String ans){
        if(i == 0){
            System.out.println(ans);
            return;
        }
        for(int j = st;j<4;j++){
            comb(j+1,i-1,ans+" b"+j);
        }
    }
}
