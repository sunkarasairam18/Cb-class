package Cb;
import java.util.*;

public class cb29 {
    static List<List<String>> ans;
    public static void main(String... args){
        ans = new ArrayList<>();
        parti("nitin",new ArrayList<>());
//        System.out.println(ans);


    }
    static void parti(String remain,List<String> temp){
        if(remain.isEmpty()){
            System.out.println(temp);
            ans.add(new ArrayList(temp)); // we are creating a copy of base case,else we just add 10K address several times
            return;                         // after completion of partitioning
        }
        String chopped,left;
        for(int i = 1;i<=remain.length();i++){
            chopped = remain.substring(0,i);
            left = remain.substring(i);
            temp.add(chopped);
            parti(left,temp);
            temp.remove(temp.size()-1);  // List array is passed as reference,they are mutable
                                            //If we pass string it creates a new string at new address, because string are immutable
                                            // So we need to undone the thing when we finish a function call.
        }
    }


}
