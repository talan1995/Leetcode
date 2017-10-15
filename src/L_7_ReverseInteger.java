
public class L_7_ReverseInteger 
{
    public int reverse(int x) 
    {
		long ret=0;
		int i=1, digit=0;
		while(x!=0)
		{
			digit= (int) (x % Math.pow(10, i));
			x-=digit;
			digit/=Math.pow(10, i-1);
			ret = ret*10 + digit;
			i++;
			if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
			{
				return 0;
			}
		}
    	return (int) ret;    
    }
    
    public int reverse_git(int x) 
    {
		long result = 0;
		while (x != 0) 
		{
			result = result * 10 + x % 10;
			x /= 10;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
		}
		return (int) (result);
	}
    public static void main(String[] agrs)
	{
		int x = 1534236469;
		L_7_ReverseInteger r = new L_7_ReverseInteger();
		System.out.println(r.reverse(x));

	}
}
