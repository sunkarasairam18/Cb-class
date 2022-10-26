package Cb;

import java.util.Arrays;

public class cb25 {
    public static void main(String... args){
//        int m = 5,l = 6;
//        for(int i = 1;i<l;i++){
//            for(int j = 0;j<m;j++){
//                System.out.print("-");
//            }
//            System.out.print(i);
//            System.out.println();
//            pat(m-1);
//        }
//        for(int j = 0;j<m;j++){
//            System.out.print("-");
//        }
//        System.out.print(6);
        int[] ans = {4,3,2,5,6,7,8,3,2,4,3};
//        System.out.println(lastOcc(ans,0,2));
        System.out.println(Arrays.toString(allOcc(ans,3,0,0)));
    }
    static int lastOcc(int[] ans,int ind,int ele){
        if(ind == ans.length){
            return -1;
        }
        int sp = lastOcc(ans,ind+1,ele);
        if(ans[ind] == ele && sp == -1){
            return ind;
        }
        return sp;
    }

    static int[] allOcc(int[] ans,int ele,int num,int ind){
        if(ind == ans.length){
            return new int[num];
        }
        int[] occ;
        if(ans[ind] == ele){
            occ = allOcc(ans,ele,num+1,ind+1);
            occ[num] = ind;
            return occ;
        }
        occ = allOcc(ans,ele,num,ind+1);
        return occ;
    }
    static void pat(int n){
        if(n == 0) return;
        pat(n-1);
        for(int i = 0;i<n;i++){
            System.out.print("-");
        }
        System.out.println();
        pat(n-1);
    }
}
