import java.util.HashMap;
import java.util.Map;

/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
/* TLE: brute force
 */
public class L_3_LongestSubstringWithoutRepeatingCharacters 
{
	public int lengthOfLongestSubstring(String s) 
	{
		Map<Character, Integer> map = new HashMap<>();
		int left=0, start=0, end=0, length, length_max = 1;
		if(s.length()==0)
		{
			return 0;
		}
		else
		{
			char[] chars = s.toCharArray();
			map.put(chars[0], 0);
			for(int i=1; i<s.length(); i++)
			{
				if(end != s.length()-1)
				{
					if(map.containsKey(chars[i]))
					{
						left = start;
						start = map.get(chars[i])+1;
						System.out.println("start: "+start);
						for(int j=left; j<start; j++)
						map.remove(chars[j]);
					}
					map.put(chars[i], i); //map里有没有都要插入进map
					end++;
					
					System.out.println("end: "+end);
					
					length = end - start + 1;
					if(length>length_max)
					{
						length_max=length;
						System.out.println("lmax: "+length_max);
					}
					System.out.println();
				}
			}
			return length_max;
		}
		
    }
	
	public int lengthOfLongestSubstring2(String s) 
	{
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        
        /*
          The reason is that if s[j] have a duplicate in the range [i, j) with index j',
​​          we don't need to increase i little by little. 
   		  We can skip all the elements in the range [i, j']
​​		  and let i to be j' + 1 directly.
        */
        
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) { //如果哈希表里已经存在了这个key，说明出现了重复的字符
                i = Math.max(map.get(s.charAt(j)), i); //把substring的start向右移动一位
            }
            ans = Math.max(ans, j - i + 1); //判断最大长度
            map.put(s.charAt(j), j + 1); //把新的一位put到哈希表里，哈希表里如果以前存在这个key，再put一遍的话，用新的位置覆盖
        }
        return ans;
    }
	
	public static void main(String[] agrs)
	{
		String s = "abcabcbb";
		L_3_LongestSubstringWithoutRepeatingCharacters l = new L_3_LongestSubstringWithoutRepeatingCharacters ();
		System.out.println(l.lengthOfLongestSubstring(s));
		Map <Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(1, 2);
		System.out.println(map.get(1));
	}
}
