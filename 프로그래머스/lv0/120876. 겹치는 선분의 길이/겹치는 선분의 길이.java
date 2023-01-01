class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        //  범위 맞춰주기
        for(int i=0; i<3; i++){
            lines[i][0] += 100;
            lines[i][1] += 100;
        }
        
        int start = 201;
        int end = 0;
        
        //  시작점, 끝점 설정
        for(int i=0; i<3; i++){
            if(lines[i][0] < start) start = lines[i][0];
            if(lines[i][1] > end) end = lines[i][1];
        }
        
        int[] line = new int[201];
        
        // 구간 표시
        for(int i=0; i<3; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                line[j]++;
            }
        }
        
        //  겹치는 구간은 한 번 이상 체크된 곳
        for(int i=0; i<end; i++){
            if(line[i] > 1) answer++;
        }
        
        return answer;
    }
}