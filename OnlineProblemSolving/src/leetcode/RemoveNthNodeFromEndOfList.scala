package leetcode

import dto.ListNode

object RemoveNthNodeFromEndOfList {
  // Link to question: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  
  def main(args: Array[String]): Unit = {
    var list1 : ListNode = new ListNode(1)
    list1.next = new ListNode(2)
    list1.next.next = new ListNode(3)
    list1.next.next.next = new ListNode(4)
    list1.next.next.next.next = new ListNode(5)
    
    val n = 2
    var head = removeNthFromEnd(list1, n)
    while(head != null){
      println(s"New List element: ${head.x}")
      head = head.next
    }
    
    var head1 = removeNthFromEnd(new ListNode(1), 1)
    while(head1 != null){
      println(s"New List element: ${head1.x}")
      head1 = head1.next
    }
  }
  
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var dummy = new ListNode(0)
    dummy.next = head
    var result : ListNode = new ListNode(0)
    
    // For counting the number of elements
    var noOfElements, counter = 0
    
    
    // Counting the number of elements in the list
    while(dummy.next != null){
      counter += 1
      dummy = dummy.next
    }
    // println(s"Number of elements in the list is: ${counter}")
    
    // If the nth element from last is the first element
    if(counter == n)
      return head.next
    
    var dummy1 = new ListNode(99)
    dummy1.next = head
    result.next = head
    
    import scala.util.control.Breaks._
    breakable{
      while(dummy1.next != null && counter >= n){
        println(s"Counter: ${counter}, n: ${n}")
        if(counter - n == 0){
          println(s"Element found: ${dummy.x}")
          dummy1.next = if(dummy1.next.next != null) 
                          dummy1.next.next 
                        else 
                           null
          break
        }
        else{
          dummy1 = dummy1.next
          counter -= 1
        }
      }
    }
    result.next
  }
}