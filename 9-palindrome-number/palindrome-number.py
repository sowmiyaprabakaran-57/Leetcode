class Solution:
    def isPalindrome(self, x: int) -> bool:
        string= str(x)
        rev_string=string[::-1]
        if string==rev_string:
            return True
        return False