package designPatterns.decorator.starbuzz;

import java.util.HashMap;
import java.util.Map;

public class TrialApplication {
    static Map<String,Integer> lengthMap = new HashMap<>();
    static int maxLength=0;
    public static int longestIncreasingPath(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
           System.out.println("--i--"+i);
            for(int j=0;j<matrix[i].length;j++){
                int length=longestPath(i,j,matrix,-1,"start");
                maxLength=Math.max(length,maxLength);
            }
        }
        return maxLength;
    }

    public static int longestPath(int i, int j,int[][] matrix, int previous,String caller){
        if(i<0 || j<0 || i >= matrix.length || j >= matrix[0].length){
            System.out.println("Return 1st loop");
            return 0;
        }
        int current = matrix[i][j];
        System.out.println(i+"_"+j+"_"+previous+"_"+matrix[i][j]+"_"+caller);
        if( previous != -1 && previous >= current){
            System.out.println("Return 2nd loop: "+previous+" current:"+current);
            return 0;
        }
        String key=i+"_"+j;
        if(lengthMap.containsKey(key)){
            return lengthMap.get(key);
        }
        int right=longestPath(i, j+1, matrix, current,"right")+1;
        System.out.println("right:"+right);
        int down=longestPath(i+1, j, matrix, current,"down")+1;
        System.out.println("down:"+down);
        int left=longestPath(i-1, j, matrix, current,"left")+1;
        System.out.println("left:"+left);
        int up=longestPath(i, j-1, matrix, current,"up")+1;
        System.out.println("up:"+up);
        int length=Math.max(left,Math.max(right,Math.max(up,down)));
        lengthMap.put(key,length);
        return length;
    }

    public static void main(String[] args) {
        int[][] matrix={{3,4,5},
                        {3,2,6},
                        {2,2,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

}
