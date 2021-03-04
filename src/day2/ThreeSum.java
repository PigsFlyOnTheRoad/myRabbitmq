package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * Demo
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * @ClassName ThreeSum
 * @Description 不重复的三元组
 * @Author cailun
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0};
        List<List<Integer>> lists = threeSum(arr);

    }
    public static List<List<Integer>> threeSum(int[] nums) {

        boolean isTrue = true;
        for (int i = 0 ; i < nums.length ;i++){
            if(nums[i] != 0){
                isTrue = false;
                break;
            }
        }


        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> row = null;
        if(isTrue && nums.length != 0){
            row = new ArrayList<>();
            for (int i = 1 ; i<nums.length ;i++){
                row.add(nums[i]);

            }
            lists.add(row);
            return lists;
        }

        for (int i = 0 ; i< nums.length ;i++){
            for (int j = i+1 ; j < nums.length ;j++){
                for (int x = j+1 ; x < nums.length ; x++){
                    if(isZero(nums[i],nums[j],nums[x])){
                        row = new ArrayList<>();
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[x]);
                        lists.add(row);
                    }
                }

            }

        }
        //去重
        boolean isFlag = true;
        int flag = 0;
        if(lists.isEmpty()){
            return lists;
        }
        List<Integer> integers = lists.get(0);
        for(int j = 1 ; j< lists.size() ;j++){
            Collections.sort(lists.get(j));
            Collections.sort(integers);
           if(lists.get(j).containsAll(integers)) {
               lists.remove(integers);
               flag++;
               j = flag+1;
               if(flag < lists.size()){
                   integers = lists.get(flag);
               }
           }
        }
        if(lists.size() == 2 && lists.get(0).containsAll(lists.get(1))){
            lists.remove(0);
        }
        return lists;
    }

    public static boolean isZero(int a,int b ,int c){
        return a+b+c == 0 ?  true : false;
    }

}
