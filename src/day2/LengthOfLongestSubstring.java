package day2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description 最长无重复串
 * @Author cailun
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "au";
        lengthOfLongestSubstring(s);



    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }

        String[] split = s.split("");
        int length1 = split.length;
        StringBuffer stringBuffer = new StringBuffer(split[0]);
        int flag = 0;
        List<StringBuffer> list = new ArrayList<>();
       // for (int i = 1 ; i < length1 ;i++){
        int i = 1;
        while ( i < length1){
            //包含
            if(stringBuffer.indexOf(split[i]) != -1){
                flag++;
                list.add(stringBuffer);
                if(flag == split.length-1){
                    break;
                }
                stringBuffer = new StringBuffer(split[flag]);
                i = flag + 1;
            }else if(i == split.length){
                stringBuffer.append(split[i]);
                flag++;
                list.add(stringBuffer);
                if(flag == split.length-1){
                    break;
                }
                stringBuffer = new StringBuffer(split[flag]);
                i = flag + 1;
            }else {
                stringBuffer.append(split[i]);
                if( i == split.length -1){
                    list.add(stringBuffer);
                }
                i++;
            }
        }


       // }
        if(!list.isEmpty()){
            StringBuffer maxLength = list.get(0);
            for (int x = 1 ; x < list.size() ; x++ ){
                StringBuffer  length = list.get(x);
                if(length.length() > maxLength.length()){
                    maxLength = length;
                }

            }
            return maxLength.length();
        }else {
            return 0;
        }
    }

}
