package day1;


import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.Arrays.*;

/**
 * @author cailun
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        int i = getSingNumber(arr);
        System.out.println(i);
    }
    public  static  int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry: entries) {
            if(1 == (Integer) entry.getValue()){
                return (int) entry.getKey();
            }
        }
        return 0;
    }

    public static Integer getSingNumber(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            if (!list.contains(arr[i])){
                list.add(arr[i]);
            }else {
                list.remove((Object) arr[i]);
            }
        }
        return list.get(0);
    }

    /**
     * 获取二叉树的最大深度
     * @param root
     * @return
     */
    static int  size  = 0;
    public int maxDepth(TreeNode root) {


        if(null == root){

            return 0;

        }
        getCount(root, size);
        return size;
    }

    public static  void getCount(TreeNode treeNode , Integer count){

        if(null == treeNode){
            return;
        }
        if( count == size){
            size++;
        }


        if(null != treeNode.left ){
            getCount(treeNode.left,count + 1);
        }
        if(null != treeNode.right){
            getCount(treeNode.right,count + 1);

        }

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static int treeMaxDepth(TreeNode treeNode){

        return null == treeNode ? 0 : Math.max(treeMaxDepth(treeNode.left),treeMaxDepth(treeNode.right))+1;

    }
}
