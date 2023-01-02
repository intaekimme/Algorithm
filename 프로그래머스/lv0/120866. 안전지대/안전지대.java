class Solution {
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] != 1) continue;
                for(int k=0; k<8; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                    if(board[nx][ny] == 1) continue;
                    board[nx][ny] = 2;
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}