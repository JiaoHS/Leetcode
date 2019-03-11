package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/11 10:49
 * @description
 */
public class 反转链表和快排 {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        reverse(a);
        while (e!=null){
            System.out.println(e.val);
            e=e.next;
        }



//        int[] arr={2,5,7,1};
//        sort1(arr,0,arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }

    private static void quickSort(int[] arr,int low, int high) {
        if (low<high){
            int index=getIndex(arr,0,arr.length-1);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void sort(int[] a, int low, int high){
        if(low > high){
            return;
        }
        int i = low; int j = high;
        int start = a[low];
        while(i < j){
            while(i<j && start <= a[j]){
                j--;
            }
            a[i] = a[j];

            while(i<j && start >= a[i]){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = start;
        sort(a, low, i-1);
        sort(a, i+1, high);
    }

    public static void sort1(int[] arr,int low ,int high){
        if(low>high) {return;}
        int i=low;
        int j=high;
        int start=arr[low];
        while (i<j){
            while (i<j&&start<=arr[j]){
                j--;
            }
            arr[i]=arr[j];
            while (i<j&&arr[i]<=start){
                i++;
            }
            arr[j]=arr[i];
        }
        arr[i]=start;
        sort1(arr,low,i-1);
        sort1(arr,i+1,high);
    }

    private static ListNode reverse2(ListNode head) {
        ListNode tmp=null;
        ListNode pre=null;
        while(head != null){
            tmp = head.next;
            head.next=pre;
            pre=head;
            head = tmp;
        }
        return head;
    }

    public static ListNode  reverse(ListNode head){
        ListNode next=null;
        ListNode pre=null;
        while (head!=null){
          next=head.next;
          head.next=pre;
          pre=head;
          head=next;

//            // 保存要反转到头的那个节点
//            next=head.next;
//            // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
//            head.next=pre;
//            // 上一个已经反转到头部的节点
//            pre=head;
//            // 一直向链表尾走
//            head=next;
        }
        return pre;
    }


}
