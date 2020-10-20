package leetcode

import dto.ListNode

object MergeTwoSortedLists {
  // Link to question: https://leetcode.com/problems/merge-two-sorted-lists/
  def main(args: Array[String]): Unit = {
    var list1 : ListNode = new ListNode(1)
    list1.next = new ListNode(2)
    list1.next.next = new ListNode(4)
    
    var list2 : ListNode = new ListNode(1)
    list2.next = new ListNode(3)
    list2.next.next = new ListNode(4)
    
    // Printing List 1
    var head1 = list1
    while(head1 != null){
      // println(s"List 1 element: ${head1.x}")
      head1 = head1.next
    }
    // Printing List 2
    var head2 = list2
    while(head2 != null){
      // println(s"List 2 element: ${head2.x}")
      head2 = head2.next
    }
    
    // Printing Merged List 
    var head3 = mergeTwoLists(list1, list2)
    while(head3 != null){
      println(s"List 3 element: ${head3.x}")
      head3 = head3.next
    }
    
  }
  
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    if(list1 == null && list2 == null)
      return null
    var head1 = list1
    var head2 = list2
    var dummy = new ListNode(0)
    var head = dummy
    
    while(head1 != null && head2 != null){
      // println(s"From List1: ${head1.x}, From List2: ${head2.x}")
      if(head1.x < head2.x){
        dummy.next = new ListNode(head1.x)
        dummy = dummy.next
        head1 = head1.next 
      }
      else{
        dummy.next = new ListNode(head2.x)
        dummy = dummy.next
        head2 = head2.next
      }
    }
    
    // If List 2 gets empty in the above loop
    if(head2 == null && head1 != null){
      dummy.next = head1
    }
    // If List 1 gets empty in the above loop
    if(head1 == null && head2 != null){
      dummy.next = head2
    }
    head.next
  }
}