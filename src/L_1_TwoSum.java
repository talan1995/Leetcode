import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
/* TLE
 * Time complexity in worst case: O(n^2).
 */

public class L_1_TwoSum 
{
	public int[] TwoSum(int[] nums, int target) 
	{
		int[] ret = new int[2];
		for(int i=0; i<nums.length; i++)
		{
			for(int j=i+1; j<nums.length; j++)
			{
				if (nums[i]+nums[j]==target)
				{
					ret[0]=i;
					ret[1]=j;
				}
			}
		}
		String retString = Arrays.toString(ret); //the way to print all elements in array
		System.out.println(retString);
		return ret;
	}

	/* 
	 * Time complexity in worst case: O(n).
	 */
	public int[] TwoSum_hash_twopass (int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int[] ret = new int[2];
	    for(int i=0; i<nums.length; i++) 
	    {
	        map.put(nums[i], i);
	    }
	    for(int i=0; i<nums.length; i++) 
	    {
	        int complement = target - nums[i];
	        if(map.containsKey(complement) && map.get(complement)!=i) 
	        {
	        	ret[0] = i;
			    ret[1] = map.get(complement);
			    System.out.println(ret[0]+" "+ret[1]);
			    return ret;
	        }
	    }
	    return ret;
	}
	
	public int[] TwoSum_hash_onepass (int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int[] ret = new int[2];
		for(int i=0; i<nums.length; i++)
		{
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement)!=i)
			{
				ret[0] = i;
			    ret[1] = map.get(complement);
			}
			else
			{
				map.put(nums[i], i);
			}
		}
		System.out.println(ret[0]+" "+ret[1]);
		return ret;
	}
	
	public static void main(String[] agrs)
	{
		L_1_TwoSum t = new L_1_TwoSum();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		t.TwoSum(nums, target);
		t.TwoSum_hash_twopass(nums, target);
		t.TwoSum_hash_onepass(nums, target);
	}
}
