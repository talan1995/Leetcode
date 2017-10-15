
/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class L_4_MedianofTwoSortedArrays 
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2) 
	{
		int m = nums1.length, n = nums2.length;
		int i = 0, j = 0;
		double prev = 0, last = 0;
		if(m+n<2)
		{
			if(m==0 && n==0)
				return 0;
			if(m==1)
				return nums1[0];
			else
				return nums2[0];				
		}
		
		while ((i+j) <= (m+n)/2)
		{
			prev = last;
			System.out.println("prev="+prev);
			
			if(i>=m)
			{
				last=nums2[j];
				j++;
			}
			else if(j>=n)
			{
				last=nums1[i];
				i++;
			}
			else if(nums1[i]<nums2[j])
			{
				last=nums1[i];
				i++;
			}
			else
			{
				last=nums2[j];
				j++;
			}	
			System.out.println("last="+last);
		}
		if((m+n)%2==0)
			return (prev+last)/2;
		else
			return last;     
    }
	
	public static void main(String[] agrs)
	{
		int[] nums1 = {1,2}, nums2 = {3,4};
		L_4_MedianofTwoSortedArrays M = new L_4_MedianofTwoSortedArrays();
		System.out.println(M.findMedianSortedArrays(nums1, nums2));
	}
}
