package Cb;

import java.util.Arrays;

public class cb36 {
    public static void main(String... args){
        int[] coins = {1,2,3,4};
//        solve_comb_wrtuser(0,4,coins,"");  // combination of coins(infinite supply)  ,so it can sum to 4. wrt user
//        solve_perm_wrtuser(4,coins,""); // permutation of coins(infinite supply), so it can sum to 4. wrt user
//        solve_comb_wrtcoin(0,4,coins,""); // combination of coins(infinite supply), so it can sum to 4. wrt each coin.
//        solve_comb_wrtuser_fin(0,4,coins,""); // combination of coins (finite supply), it can sum to 4,wrt user.
        int[] dupcoins = {1,2,2,3,2,4,5,3};
        Arrays.sort(dupcoins);
        solve_comb_dup_wrtcoin(0,dupcoins,false,8,""); // unique combination with duplicate coins wrt coins ,so it can sum to 8.
        System.out.println("----");
        solve_comb_dup_wrtuser(0,dupcoins,8,""); // unique combination with duplicate coins wrt user ,so it can sum to 8.
    }
    //infinite supply comb wrt user
    static void solve_comb_wrtuser(int i,int sum,int[] coins,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum<0) return;
        for(int j = i;j<coins.length;j++){
            solve_comb_wrtuser(j,sum-coins[j],coins,path+" "+coins[j]);
        }

    }
    //infinite supply perm wrt user
    static void solve_perm_wrtuser(int sum,int[] coins,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum<0) return;
        for(int i = 0;i<coins.length;i++){
            solve_perm_wrtuser(sum-coins[i],coins,path+" "+coins[i]);
        }
    }

    // infinite supply combin wrt coin
    static void solve_comb_wrtcoin(int i,int sum,int[] coins,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum < 0 || i == coins.length) return;
        solve_comb_wrtcoin(i,sum-coins[i],coins,path+" "+coins[i]);
        solve_comb_wrtcoin(i+1,sum,coins,path);
    }

    // finite supply ,combin wrt user,coins are unique
    static void solve_comb_wrtuser_fin(int i,int sum,int[] coins,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum<0) return;

        for(int j = i;j<coins.length;j++){
            solve_comb_wrtuser_fin(j+1,sum-coins[j],coins,path+" "+coins[j]);
        }

    }
    // coins are duplicate ,combination finite,target sum
    // {2,2,4,5,6} target = 6 , select curr if prev is same and selected,dont select if prev is same and not selected.
    // wrt coin
    static void solve_comb_dup_wrtcoin(int i,int[] coins,boolean prevsel,int sum,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum<0 || i == coins.length) return;

        if(i>0 && coins[i] == coins[i-1] && !prevsel){
            solve_comb_dup_wrtcoin(i+1,coins,false,sum,path);
        }else{
            solve_comb_dup_wrtcoin(i+1,coins,true,sum-coins[i],path+" "+coins[i]);
            solve_comb_dup_wrtcoin(i+1,coins,false,sum,path);
        }
    }

    // duplicate coins,target sum,wrt user
    static void solve_comb_dup_wrtuser(int i,int[] coins,int sum,String path){
        if(sum == 0){
            System.out.println(path);
            return;
        }
        if(sum<0) return;

        for(int j = i;j<coins.length;j++){
            if(j == i || coins[j] != coins[j-1]){
                solve_comb_dup_wrtuser(j+1,coins,sum-coins[j],path+" "+coins[j]);
            }

        }

    }
}
