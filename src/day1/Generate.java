package day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Generate
 * @Description 杨辉三角
 * @Author cailun
 */
public class Generate {


    public static void main(String[] args) {

    }
    /**
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> Column = new ArrayList<>();
        List<Integer> row = null;
        for(int i = 0 ;i < numRows ;i++){
            row = new ArrayList<>();
            for(int j = 0 ; j <= i;j++){
                //第一二行
                if( j == 0 || i == j){
                    row.add(1);
                }else {
                    //相邻两个元素
                    row.add(Column.get(i-1).get(j-1)+Column.get(i-1).get(j));
                }

            }
            Column.add(row);
        }
        return  Column;

    }


}
