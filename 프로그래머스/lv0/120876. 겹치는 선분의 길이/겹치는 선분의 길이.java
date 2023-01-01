class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        for(int i=0; i<3; i++){
            lines[i][0] += 100;
            lines[i][1] += 100;
        }
        
        int start = 201;
        int end = 0;
        
        for(int i=0; i<3; i++){
            if(lines[i][0] < start) start = lines[i][0];
            if(lines[i][1] > end) end = lines[i][1];
        }
        
        int[] line = new int[201];
        
        for(int i=0; i<3; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                line[j]++;
            }
        }
        
        for(int i=0; i<end; i++){
            if(line[i] > 1) answer++;
        }
        
        return answer;
    }
}