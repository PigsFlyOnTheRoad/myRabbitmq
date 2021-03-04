package day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;



//我丢写不出
/**
 * @ClassName LongestPalindrome
 * @Description 最长回文串
 * @Author cailun
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        longestPalindrome("tattarrattat");
    }
    /**
     * Demo
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.isEmpty()){
            return null;
        }
        String[] split = s.split("");
        String string = new String(split[0]);
        List<String> list = new ArrayList<>();
        //游标
        int flag = 0;
        if(s.length() == 1 && isPalindrome(string)){
            list.add(string);
        }
        if(s.length()%2== 0 && s.substring(0,s.length()/2).equals(new StringBuilder(s.substring(s.length()/2)).reverse()+"")){
            return s;
        }
        //长度不超过2
        if(s.length() == 2  ){
            if(!split[0].equals(split[1])){
                return split[0];
            }else {
                return s;
            }
        }
        //针对长度超过2
        for (int i = 1 ; i < split.length ; i++){
            string = string.concat(split[i]);
            if(isPalindrome(string)){
                list.add(string);
            }
            if(i == split.length-1){
                flag++;
                i=flag;
                string = split[flag];
            }
        }
        String maxLength = "";
        if(!list.isEmpty()){
            maxLength = list.get(0);
        }
        for (int j = 1 ;j<list.size();j++){

            if(maxLength.length() < list.get(j).length()){
                maxLength = list.get(j);
            }
        }
        return maxLength == "" ? split[0]  : maxLength;
    }

    /**
     * 是否是回文串
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string){

        if(null == string){
            return false;
        }
        if(string.length() == 1){
            return true;
        }
        //双数
        if(string.length() % 2 == 0 ){
            if(string.substring(0,string.length()/2).equals(new StringBuilder(string.substring(string.length()/2)).reverse())){
                return true;
            }
            /*HashSet<String> start = new HashSet<>();
            HashSet<String> end = new HashSet<>();*/
            String[] startSubstring = string.substring(0, string.length() / 2).split("");
            String[] endSubstring = string.substring(string.length() / 2).split("");

            for (int i = 0; i< startSubstring.length ;i++){
                if(!startSubstring[i].equals(endSubstring[i])){
                    return false;
                }
            }
            return true;
        }else{
            String substring = string.substring(0, string.length() / 2 + 1);
            String reverse = new StringBuilder(string.substring(string.length() / 2)).reverse() + "";
            boolean equals = substring.equals(reverse);
            return equals;
        }
    }
}
