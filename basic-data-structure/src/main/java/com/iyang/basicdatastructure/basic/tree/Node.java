package com.iyang.basicdatastructure.basic.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/1 23:23
 * @Version 1.0
 * @qq: 1411091515
 *
 * 节点类
 */
public class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 前序迭代,使用递归的方式
     * @param head
     */
    public void preOrderRecur(Node head){
        if(head == null){ return ;}
        System.out.print(head.value + "  ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序排序,使用递归的方式
     * @param head
     */
    public void inOrderRecur(Node head){
        if(head == null){ return; }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 后序排序,使用递归的方式
     * @param head
     */
    public void posOrderRecur(Node head){
        if(head == null){ return; }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
     * 前序迭代,使用非递归的方式
     * @param head
     */
    public void oreOrderUnRecur(Node head){
        System.out.println(" pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                // 弹出 Head
                head = stack.pop();
                System.out.println(head.value + "  ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void inIrderUnRect(Node head){
        System.out.println("in-order : ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){

                // 如果 head 不是null, 则就是还有节点信息的值
                if(head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public void posOrderUnRecur(Node head){
        System.out.println("pos-order: ");
        if(head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }

        System.out.println();
    }

    public void printEdge1(Node head){
        if(head == null){ return; }


    }

    public int getHeight(Node h,int l){
        if(h == null){
            return l;
        }
        return Math.max(getHeight(h.left,l+1),getHeight(h.right,l+1));
    }

    public void setEdgeMap(Node h,int l,Node[][] edgeMap){
        if(h == null){ return; }
        edgeMap[1][0] = edgeMap[1][0] == null ? h : edgeMap[1][0];
        edgeMap[1][1] = h;
        setEdgeMap(h.left,l+1,edgeMap);
        setEdgeMap(h.right,l + 1,edgeMap);
    }

    public int getMaxLength(Node head,int sum){
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }

    public int preOrder(Node head,int sum,int preSum,int level,int maxLen,HashMap<Integer,Integer> sumMap){
        if(head == null){
            return maxLen;
        }
        int curSum = preSum + head.value;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if(sumMap.containsKey(curSum - sum)){
            maxLen = Math.max(level-sumMap.get(curSum - sum),maxLen);
        }
        preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);
        if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }

}
