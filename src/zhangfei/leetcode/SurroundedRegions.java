package zhangfei.leetcode;

/**
 * Created by Fei Zhang on 2016/4/4.
 * Email:zhangfei614@126.com
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 思路1：使用DFS出现stackoverflow问题，不可取。
 思路2：使用BFS出现超时问题，不可取。!!!!!广度优先遍历的时候，加入队列之前要看是否被访问过。而深度优先遍历，因为在条件时已经判断过，所以不用。
 思路3：只对边缘上的‘O'利用dfs进行处理，处理完成后，将剩余的‘O’置为x，再将进行边缘的‘O’进行恢复。

 注意：原来的思路都是正确的，但是有几点问题！在加入队列之前就要将邻近的状态改变！
 */

public class SurroundedRegions {
//
//    public void solve(char[][] board) {
//        if(board.length == 0) return;
//        for(int i = 0; i < board.length; i++)
//            for(int j = 0; j < board[i].length; j++){
//                if(board[i][j] =='O'){
//                    List<Index> list = new ArrayList<Index>();
//                    boolean flag = dfs(board,i,j,list);
//                    if(flag == true){
//                        for(Index index : list){
//                            board[index.x][index.y]='X';
//                        }
//                    }
//                }
//            }
//
//        for(int i = 0; i < board.length; i++)
//            for(int j = 0; j < board[i].length; j++)
//                if(board[i][j]=='Y') board[i][j]='O';
//
//    }
//
//    private boolean dfs(char[][] board,int i,int j,List list){
//        if(i < 0 || j < 0 ||i == board.length || j == board[0].length ) return false;
//        else if(board[i][j]=='X' || board[i][j]=='Y') return true;
//        else{
//            list.add(new Index(i,j));
//            board[i][j]='Y';
//            boolean flag = true;
//            flag &= dfs(board,i-1,j,list);
//            flag &= dfs(board,i+1,j,list);
//            flag &= dfs(board,i,j-1,list);
//            flag &= dfs(board,i,j+1,list);
//            return flag;
//        }
//    }


     static class Index{
        int x;
        int y;
        public Index(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

//    public void solve(char[][] board) {
//        if (board.length == 0) return;
//        for (int i = 0; i < board.length; i++)
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 'O') {
//                    List<Index> list = new ArrayList<Index>();
//                    boolean flag = bfs(board, i, j, list);
//                    if (flag == true) {
//                        for (Index index : list) {
//                            board[index.x][index.y] = 'X';
//                        }
//                    }
//                }
//            }
//        for(int i = 0; i < board.length; i++)
//            for(int j = 0; j < board[i].length; j++)
//                if(board[i][j] == 'Y') board[i][j]='O';
//    }
//
//    public boolean bfs(char[][] board,int i,int j,List<Index> list){
//        int index = 0;
//        boolean flag = true;
//        list.add(new Index(i,j));
//        while(index != list.size()){
//            int x = list.get(index).x;
//            int y = list.get(index).y;
//            board[x][y]='Y';
//            if(x == 0 || x  == board.length-1 || y == 0|| y == board[i].length -1) flag = false;
//            if(x-1 >= 0 && board[x-1][y]=='O') list.add(new Index(x-1,y));
//            if(x+1 < board.length && board[x+1][y]=='O') list.add(new Index(x+1,y));
//            if(y-1 >= 0 && board[x][y-1]=='O') list.add(new Index(x,y-1));
//            if(y+1 < board[x].length && board[x][y+1]=='O') list.add(new Index(x,y+1));
//            index++;
//        }
//        return flag;
//    }


    /**
     * 采用只遍历边的方法。
     */
//    public void solve(char[][] board) {
//        if(board.length == 0) return;
//        for (int i = 0; i < board.length; i++)
//            for (int j = 0; j < board[i].length; j++) {
//                if(i == 0 || j == 0 || i == board.length -1 || j ==board[i].length-1){
//                    if(board[i][j] == 'O'){
//                        bfs(board, i, j);
//                    }
//                }
//            }
//        for(int i = 0; i < board.length; i++)
//            for(int j = 0; j < board[i].length; j++){
//                if(board[i][j]=='O') board[i][j]='X';
//                if(board[i][j]=='Y') board[i][j]='O';
//            }
//    }
//
//    private void dfs(char[][] board,int i,int j){
//        board[i][j]='Y';
//        if (i - 1 > 0 && board[i - 1][j]=='O') dfs(board,i-1,j);
//        if (i + 1 < board.length-1 && board[i + 1][j]=='O') dfs(board,i+1,j);
//        if (j - 1 > 0 && board[i][j - 1]=='O') dfs(board,i,j-1);
//        if (j + 1 < board[i].length-1 && board[i][j + 1]=='O') dfs(board,i,j+1);
//    }

//    private void bfs(char[][] board,int x,int y){
//        Queue<Index> queue = new ArrayDeque<Index>();
//        queue.add(new Index(x,y));
//        while (!queue.isEmpty()){
//            Index index = queue.remove();
//            int i = index.x;
//            int j = index.y;
//            board[i][j] = 'Y';
//            if (i - 1 > 0 && board[i - 1][j]=='O') {
//                board[i-1][j] = 'Y';
//                queue.add(new Index(i-1,j));
//            }
//            if (i + 1 < board.length-1 && board[i + 1][j]=='O') {
//                board[i+1][j] = 'Y';
//                queue.add(new Index(i + 1, j));
//            }
//            if (j - 1 > 0 && board[i][j - 1]=='O') {
//                board[i][j-1] = 'Y';
//                queue.add(new Index(i , j-1));
//            }
//            if (j + 1 < board[i].length-1 && board[i][j + 1]=='O') {
//                board[i][j+1] = 'Y';
//                queue.add(new Index(i, j + 1));
//            }
//        }
//    }

}
