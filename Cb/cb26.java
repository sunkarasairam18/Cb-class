package Cb;

public class cb26 {
    public static void main(String... args){

//        toss(3,"");
//        subseq("abc",0,"");
        noconsT(3,'H',"");

    }
    static void toss(int coin,String ans){
        if(coin == 0){
            System.out.println(ans);
            return;
        }
        toss(coin-1,ans+"H");
        toss(coin-1,ans+"T");
    }
    static void subseq(String s,int i,String ans){
        if(i == s.length()){
            System.out.println(ans);
            return;
        }
        char c = s.charAt(i);
        subseq(s,i+1,ans+c);
        subseq(s,i+1,ans);

    }
    static void noconsT(int coin,char prev,String ans){
        if(coin == 0){
            System.out.println(ans);
            return;
        }
        noconsT(coin-1,'H',ans+"H");
        if(prev != 'T') noconsT(coin-1,'T',ans+"T");

    }
}
