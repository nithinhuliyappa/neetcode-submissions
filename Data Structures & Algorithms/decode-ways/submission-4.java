class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        //fill with -1 because 0 is valid answer, if used Integer[] you can use null;
        Arrays.fill(memo, -1);
        return decode(0, s, memo);
    }

    public int decode(int i, String s, int[] memo) {
        //reached the end of string - this means we have one way (this one way of decoding entire string not just the last char of the string) of decoding.
        if(i == s.length())
            return 1;

        //'0' alone is not valid
        if(s.charAt(i)=='0')
            return 0;

        //get result from memo, if already computed
        if(memo[i] != -1)
            return memo[i];

        //take one digit and recursively decode rest. eX: 226, take 2(idx:0) and        recursively decode 26 (from idx:1)
        int ways = decode(i+1, s, memo);

        //1) take two digits and recurively decode rest ex: 226, take 22(idx:0 & idx:)and recursively decode 2 (from idx:2). 
        //2) but there are challenges you need make sure two digit you consider with the range  10>= 2 digit num(i.e 22)<=26. otherwise path will be invalid
        //3) also make sure i+2 is within the s.length
        if(i < s.length()-1){
            int twoDigit = Integer.parseInt(s.substring(i, i+2));
            if(twoDigit >= 10 && twoDigit <= 26){
                ways += decode(i+2, s, memo);
            }
        }

        //store result in memo
        memo[i] = ways;
        return ways;
    }
}
