package Cb;

public class cb28 {
    public static void main(String... args){

//        for(int i = 1;i<10;i++){
//            lexi(i,100);
//        }

//        for(int i = 1;i<10;i++){
//            jumping(i,105);
//            System.out.println();
//            System.out.println("----");
//        }
        parition("nitin","");
//        String s = "nitin";
//        System.out.println(s.substring(2));
    }
    static void lexi(int i,int n){
        if(i>n) return;

        System.out.println(i);
        for(int j = 0;j<10;j++){
            lexi(i*10+j,n);
        }


    }
    static void jumping(int i,int l){
        if(i>l) return;
        int di = i%10;
        System.out.print(i+" ");
        if(di>0)
            jumping(i*10+di-1,l);

       if(di<9) jumping(i*10+di+1,l);
    }
    static void parition(String remain,String parts){
        if(remain.equals("")){
            System.out.println(parts);
            return;
        }
        String chopped,left;
        for(int i = 1;i<=remain.length();i++){
            chopped = remain.substring(0,i);
            left = remain.substring(i);
            parition(left,parts+" "+chopped);
        }
    }
}
