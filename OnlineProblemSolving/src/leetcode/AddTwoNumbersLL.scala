package leetcode

import dto.ListNode

//class ListNode(var _x: Int = 0) {
//  var next: ListNode = null
//  var x: Int = _x
//}

object AddTwoNumbersAgain {
    // Link to question: https://leetcode.com/problems/add-two-numbers/
  
    def main(args: Array[String]): Unit = {
      var l1 = new ListNode(1)
      l1.next = new ListNode(8)
      
      var l2 = new ListNode(9)
      l2.next = new ListNode(9)
      l2.next.next = new ListNode(1)
      
      var result: ListNode = addTwoNumbers(l1, l2)
      println("Result is: ") 
      while(result != null){
        print(s"${result.x}\t")
        result = result.next
      }
    }
        
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
      var list1 = l1
      var list2 = l2
      var dummyHead: ListNode = new ListNode(0)
      
      var current: ListNode = dummyHead
      var tempSum = 0 
      var carry = 0
      
      // Add the corresponding elements from the list till overlap is observed
      while(list1 != null && list2 != null){
        println(s"list1 data: ${list1.x} & list2 data:${list2.x}")
        tempSum = list1.x + list2.x + carry
        if(tempSum > 9){
          carry = tempSum / 10
          tempSum = tempSum % 10
        }else{
          carry = 0 
        }
        current.next = new ListNode(tempSum)
        current = current.next
        
        list1 = list1.next
        list2 = list2.next
      }
      
      // Add the remaining elements from the non empty list.
      while(list1 != null || list2 != null){
          println(s"Element is remaining in: " + ((if(list1 != null) "list1"  else "list2" )) )
          
          tempSum = (if(list1 != null) list1.x  else list2.x ) + carry
          var element = if(list1 != null) list1.x  else list2.x 
          println(s"Adding from the remaining elements. ${element} and carry = ${carry} and tempSum = ${tempSum}")
          if(tempSum > 9){
            carry = tempSum / 10
            tempSum = tempSum % 10
          }
          else
            carry = 0 
          println(s"Adding this to link list: ${tempSum}")
          current.next = new ListNode(tempSum)
          current = current.next
          (if(list1 != null) (list1 = list1.next)  else (list2 = list2.next ))
      }
      
      // Taking care of carry - if carry != 0
      if(carry != 0){
        println(s"Carry was still pending to be settled. carry = ${carry}")
        current.next = new ListNode(carry)
        current = current.next
      }
      dummyHead.next
    }
    
}