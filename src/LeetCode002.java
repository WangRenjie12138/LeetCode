public class LeetCode002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位变量
        int cf = 0;
        ListNode result = new ListNode();
        ListNode node1 = l1, node2 = l2, node3 = result;

        node3.val = (node1.val + node2.val + cf) % 10;
        cf = ((node1.val + node2.val + cf) / 10);
        node1 = node1.next;
        node2 = node2.next;

        while(node1 != null && node2 != null){
            ListNode newOne = new ListNode();
            newOne.val = (node1.val + node2.val + cf) % 10;
            newOne.next = null;
            cf = ((node1.val + node2.val + cf) / 10);

            node3.next = newOne;
            node3 = node3.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while(node1 != null){
            ListNode newOne = new ListNode();
            newOne.val = (node1.val + cf)%10;
            newOne.next = null;
            cf = ((node1.val + cf)/10);

            node3.next = newOne;
            node3 = node3.next;
            node1 = node1.next;
        }

        while(node2 != null){
            ListNode newOne = new ListNode();
            newOne.val = (node2.val + cf) % 10;
            newOne.next = null;
            cf = ((node2.val + cf) / 10);

            node3.next = newOne;
            node3 = node3.next;
            node2 = node2.next;
        }

        if(cf == 1){
            ListNode newOne = new ListNode();
            newOne.val = cf;
            newOne.next = null;

            node3.next = newOne;
        }

        return result;

    }

    public void start(){
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(4,node3);
        ListNode l1 = new ListNode(2,node2);

        ListNode n3 = new ListNode(4,null);
        ListNode n2 = new ListNode(6,n3);
        ListNode l2 = new ListNode(5,n2);

        ListNode res = addTwoNumbers(l1,l2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static void main(String[] args){
        LeetCode002 leet = new LeetCode002();
        leet.start();
    }

}
