package Cb;

public class cb32 {
    public static void main(String... args){
        //        placeQwrtseats(1,2,4,"");  // placing 2 queens in 4 seats wrt seat wise.
//        nqueen(0,0,3,3,2,""); // place 2 queens in 3 by 3 board,show all combinations.
        boolean[][] board = new boolean[3][3];
        placequensafely(0,0,3,3,2,"",board);  // Placing 2 queens in 3 X 3 board,so queens dont attack each other.
    }
    static void placeQwrtseats(int seat,int qn,int total,String ans){  // going to a seat choosing whether qn sits in that seat then going to next seat.
        if(qn == 0){                    // if there are 4 seats and 2 qns,we placed 2 nd qn in 4 th seat,no qns left,u visited 5 th seat
            System.out.println(ans);    // here we got +ve case and also -ve case but we need +ve so we need +ve above -ve base case.
            return;
        }
        if(seat == total+1){
            return;
        }

        placeQwrtseats(seat+1,qn-1,total,ans+" s"+seat); // placing qn in this seat,so one reduction in qn count.
        placeQwrtseats(seat+1,qn,total,ans);  //Not placing qn in this seat,no reduction in qn count.

    }
    static void nqueen(int r,int c,int m,int n,int qncount,String ans){
        if(qncount == 0){
            System.out.println(ans);
            return;
        }
        if(c == n){
            r++;
            c = 0;
        }
        if(r == m) return;
        nqueen(r,c+1,m,n,qncount-1,ans+" Q{"+r+","+c+"}");
        nqueen(r,c+1,m,n,qncount,ans);
    }

    static void placequensafely(int r,int c,int m,int n,int qncount,String ans,boolean[][] board){
        if(qncount == 0){
            System.out.println(ans);
            return;
        }
        if(c == n){
            r++;
            c = 0;
        }
        if(r == m) return;
        if(isSafe(r,c,board)){
            board[r][c] = true;
            placequensafely(r,c+1,m,n,qncount-1,ans+" Q{"+r+", "+c+"}",board);
            board[r][c] = false;
        }
        placequensafely(r,c+1,m,n,qncount,ans,board);
    }
    static boolean isSafe(int r,int c,boolean[][] board){
        for(int cl = c;cl>-1;cl--){
            if(board[r][cl]) return false;
        }
        for(int rl = r;rl>-1;rl--){
            if(board[rl][c]) return false;
        }
        int R = r,C = c;
        while(R>-1 && C>-1){
            if(board[R][C]) return false;
            R--;
            C--;
        }
        R = r;
        C = c;
        while(R>-1 && C<board[0].length){
            if(board[R][C]) return false;
            R--;
            C++;
        }
        return true;
    }

}
