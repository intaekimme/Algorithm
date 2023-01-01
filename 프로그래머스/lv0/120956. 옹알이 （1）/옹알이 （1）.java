class Solution {
    public static final String[] voice = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        //  모든 단어 확인
        for(int i=0; i<babbling.length; i++){
            int j = 0;
            //  검사가 실패하지 않으면 true 유지
            boolean check = true;
            //  단어 1개의 길이의 검사가 끝날때까지 반복
            here: while(j < babbling[i].length()){
                int cnt = 0;
                
                //  단어 1개의 부분문자열을 옹알이와 비교
                for(int k=0; k < voice.length; k++){
                    String subBabbling = "";
                    try{
                        subBabbling = babbling[i].substring(j, j + voice[k].length());
                    } catch(Exception e){
                        System.out.println("babbling : " + babbling[i]);
                        System.out.println("voice : " + voice[k]);
                        System.out.println("j, k : " + j + ", " + k);
                    }
                    
                    
                    //  부분 문자열이 옹알이와 같으면
                    if(voice[k].equals(subBabbling)){
                        //  다음 부분 문자열 확인을 위해 index 증가
                        j += voice[k].length();
                        break;
                    }
                    
                    //  옹알이 4개를 다 확인했는데
                    if(++cnt == 4){
                        // 같은게 없는 것이므로 실패 확정 후
                        check = false;
                        // 검사 종료 후 다음 단어 확인
                        break here;
                    }
                }   //  end of for
            }   //  end of while
            
            // 발음할 수 있는 단어이면 answer 증가
            if(check)
                answer += 1;
        }
        
        return answer;
    }
}