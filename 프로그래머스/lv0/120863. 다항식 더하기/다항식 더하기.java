class Solution {
    public String solution(String polynomial) {
        
        String[] arr = polynomial.split(" ");
        
        int xSum = 0;
        int nSum = 0;
        
        for(int i=0; i<arr.length; i++){
            //  '3x'와 같은 문자라면
            if(arr[i].charAt(arr[i].length() - 1) == 'x'){
                //  x를 제외한 숫자를 더함
                if(arr[i].length() > 1)
                    xSum += Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
                else
                    xSum += 1;
            } else{
                //  연산자가 아니면 더함
                if(!arr[i].equals("+"))
                    nSum += Integer.parseInt(arr[i]);
            }
        }// end of for
        
        if(xSum != 0 && nSum != 0){
            if(xSum != 1)
                return Integer.toString(xSum) + "x + " + Integer.toString(nSum);
            return "x + " + Integer.toString(nSum);
        }
        if(xSum !=0){
            if(xSum != 1)
                return Integer.toString(xSum) + "x";
            return "x";
        }
        if(nSum != 0)
            return Integer.toString(nSum);
        return "";
    }
}