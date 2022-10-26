package Cb;

public class cb34 {
    public static void main(String... args){
        combwrtbox(1,2,4,""); // Select 2 boxes out of 4 wrt box where arrangement not matters.

        //https://leetcode.com/problems/n-queens-ii/
    }
    static void combwrtbox(int i,int count,int limit,String ans){
        if(count == 0){
            System.out.println(ans);
            return;
        }
        if(i == limit+1){
            return;
        }
        combwrtbox(i+1,count-1,limit,ans+"b{"+i+"}");
        combwrtbox(i+1,count,limit,ans);
    }
}
