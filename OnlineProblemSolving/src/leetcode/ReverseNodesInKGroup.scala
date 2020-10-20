package leetcode

import dto.ListNode

object ReverseNodesInKGroup {
  // Link to question: https://leetcode.com/problems/reverse-nodes-in-k-group/
  
  def main(args: Array[String]): Unit = {
	  var list1 : ListNode = new ListNode(1)
    list1.next = new ListNode(2)
    list1.next.next = new ListNode(3)
    list1.next.next.next = new ListNode(4)
    list1.next.next.next.next = new ListNode(5)
	  
	  reverseKGroup(list1, 2)
  }
  
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    // Edge case - 1: No swap required
    if(k < 2)
      return head
    
    // Count the number of elements in the LinkedList
    var dummy = new ListNode(99)
    dummy.next = head
    
    var noOfElements = 0
    while(dummy != null){
      if(dummy.next != null)
        noOfElements += 1
      dummy = dummy.next
    }
    println(s"No of elements: ${noOfElements}")
    
    // Edge case - 2: Number of elements in LinkedList < k, no swapping required
    if(noOfElements < k)
      return head
    
    var swapCounter = 0
    var globalCounter = 0
    var dummy1 = new ListNode(99)
    dummy1.next = head // to do the actual K group reversal of LinkedList
    
    while(dummy1 != null || noOfElements - globalCounter > k){
      // Start Point
      var startNode = dummy1.next
      
      if(swapCounter < k){
        
      }
    }
    
    null
  }
}