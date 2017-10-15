/* Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class L_5_LongestPalindromicSubstring 
{
	public String longestPalindrome(String s) 
	{
		int length_max=0;
		String longestPalindrome=null;
		
		if (s.isEmpty()) 
			return null;
		
		if (s.length() == 1) 
			return s;
		
		for(int i=0; i<s.length(); i++)
		{
			String sub = longestPalindrome_search(s, i, i);
			
			if(sub.length()>length_max)
			{
				longestPalindrome=sub;
				length_max=sub.length();
			}
			
			sub = longestPalindrome_search(s, i, i+1);
			if(sub.length()>length_max)
			{
				longestPalindrome=sub;
				length_max=sub.length();
			}
		}
		return longestPalindrome;  
    }
	
	public String longestPalindrome_search(String s, int start, int end) 
	{
		while(start>=0 && end<=s.length()-1 && s.charAt(start)==s.charAt(end))
	    //大于等于0是因为，如果只是大于0，首末两个字符没法判断了
		{
			start--;
			end++;
		}
		return s.substring(start+1, end); //substring(a,b)函数返回的是从 a 到 b-1 的substring
	}	
	
	public static void main(String[] agrs)
	{
		String s = "abcba";
		L_5_LongestPalindromicSubstring l = new L_5_LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));
	}
}
