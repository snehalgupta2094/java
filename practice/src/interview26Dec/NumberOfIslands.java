package interview26Dec;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
* */
public class NumberOfIslands {

    public static void findIsland(int i, int j,String[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j].equals("0") || grid[i][j].equals("2")){
            return;
        }
        grid[i][j]="2";
        findIsland(i+1,j,grid);
        findIsland(i-1,j,grid);
        findIsland(i,j+1,grid);
        findIsland(i,j-1,grid);
    }
    public static void main(String[] args) {
        int count=0;
        String[][] grid={{"1","1","1","1","0"},
                         {"1","1","0","1","0"},
                         {"1","1","0","0","0"},
                         {"0","0","1","1","1"}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j].equals("1")){
                    findIsland(i,j,grid);
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
