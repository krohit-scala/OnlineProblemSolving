package leetcode

import dto.ListNode

object SwapNodesInPairs {
  // Link to question: https://leetcode.com/problems/swap-nodes-in-pairs/
  def main(args: Array[String]): Unit = {
    val myNode : ListNode = new ListNode(1)
    myNode.next = new ListNode(2)
    myNode.next.next = new ListNode(3)
    myNode.next.next.next = new ListNode(4)
    
    swapPairs(myNode)
  }
  
  def swapPairs(head: ListNode): ListNode = {
    var headPointer : ListNode = new ListNode(99)
    var curent : ListNode = headPointer
    
    headPointer.next = head // This is the reference to be returned
    
    while(curent.next!= null && curent.next.next != null){
      var nextNode = curent.next.next
      curent.next.next = nextNode.next
      nextNode.next = curent.next
      curent.next = nextNode
      curent = nextNode.next
    }
    
    headPointer.next
  }
}