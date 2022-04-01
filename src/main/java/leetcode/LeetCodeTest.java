package leetcode;

import org.junit.Test;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class LeetCodeTest {

    /**
     * 两数相加
     * 采用链表方式 存储和输出
     * ************
     * 逆序存储
     * ***********
     * */
    @Test
    public void demo() {
         class ListNode{
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val){
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

         class Solution{
            ListNode addTwoNumbers(ListNode l1,ListNode l2) {
                ListNode listNode = new ListNode();
                ListNode head  = listNode;
                int carray = 0;
                while (l1!=null || l2!=null || carray != 0){
                    int l1val = l1 != null ? l1.val : 0;
                    int l2val = l2 != null ? l2.val : 0;
                    // 和
                    int sumval = l1val + l2val + carray;
                    // 进位值
                    carray = sumval/10;
                    // 存储值
                    ListNode listNode1 = new ListNode(sumval % 10);
                    head.next = listNode1;
                    head = listNode1;
                    if (l1!=null) l1 = l1.next;
                    if (l2!=null) l2 = l2.next;
                }
                return listNode.next;
            }
        }
        ListNode l7 = new ListNode(2);
        ListNode l3 = new ListNode(3,l7);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(2,l2);



        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(6, l6);
        ListNode l4 = new ListNode(5, l5);
        Solution solution = new Solution();
        ListNode listNode =  solution.addTwoNumbers(l1, l4);

        System.out.print("head->");
        do {
            if (listNode == null) {
                System.out.println("null");
                break;
            }
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        } while (listNode!=null);
        System.out.println("\n");

        /*
        * if (l1 == null) {
                    return l2;
                }
                if (l2 == null) {
                    return  l1;
                }
                ListNode listNode = new ListNode();
                ListNode head = listNode;
                do {
                    listNode.val = l1.val + l2.val;
                    listNode.next = new ListNode();
                    listNode = listNode.next;
                    l1=l1.next;
                    l2=l2.next;
                } while ((l1!=null) && (l2!=null));

                if (l1 != null) {
                    listNode = l1;
                } else if (l2!=null){
                    listNode = l2;
                }

                return head;
            }
            */
        // 失败
        //[7,10,7,0]
        // 预期 ： [7,0,8]
    }

    @Test
    public void demo1() {

    }

}

