/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class L_2_AddTwoNumbers 
{ 
	public class ListNode 
	{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		int carry = 0;
		ListNode newHead = new ListNode(0); //初始化，ListNode(0)的意识是这个Node里面存的值是0
		ListNode p1 = l1, p2 = l2, p3 = newHead; //把newhead赋值给p3，两个的指针就都一样了
		while (p1 != null || p2 != null || carry != 0) //防止有一个list没有结束的情况，和最高位有进位的情况
		{
			if(p1 != null) 
			{
				carry += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) 
			{
				carry += p2.val;
				p2 = p2.next;
			}
			int digit=carry%10; 
			
			p3.next = new ListNode(digit); //p3的第一个节点不用，直接定义p3的next
			p3 = p3.next; //指针指向下一个
			carry /= 10;
			
		}
		return newHead.next; //因为第一个是无用节点，从第二个开始返回
	}

}


 
