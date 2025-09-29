class Solution {
    public String reverseVowels(String s) {
        if (s==null||s.length()==0) return s;
        Stack<Character> vowels=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(isVowel(c))
            {
                vowels.push(c);
            }
        }
        StringBuilder result=new StringBuilder();
        for(char c:s.toCharArray())
        {
            if(isVowel(c))
            {
                result.append(vowels.pop());
            }
            else
            {
                result.append(c);
            }
        }
        return result.toString();
    }
    private boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}