public class moves {
    
    public void moveRight(int[][] grid, int row){

        int prev = grid[row][0];
        int stor = prev;
        for(int i = 1; i < grid.length; i++){
            prev = stor;
            stor = grid[row][i];
            grid[row][i] = prev;
        }
        grid[row][0] = stor;

    }
    public void moveLeft(int[][] grid, int row){

        int prev = grid[row][grid.length-1];
        int stor = prev;
        for(int i = grid.length - 2; i >=0; i--){
            prev = stor;
            stor = grid[row][i];
            grid[row][i] = prev;
        }
        grid[row][grid.length-1] = stor;

    }
    public void moveUp(int[][] grid, int col){

        int prev = grid[0][col];
        int stor = prev;
        for(int i = 1; i < grid.length; i++){
            prev = stor;
            stor = grid[i][col];
            grid[i][col] = prev;
        }
        grid[0][col] = stor;

    }
    public void moveDown(int[][] grid, int col){

        int prev = grid[grid.length-1][col];
        int stor = prev;
        for(int i = grid.length - 2; i >=0; i--){
            prev = stor;
            stor = grid[i][col];
            grid[i][col] = prev;
        }
        grid[grid.length-1][col] = stor;

    }

    public static void main(String args[]){
        moves m = new moves();
        grid g = new grid();
        int[][] grid = g.getGrid(3);
        m.moveLeft(grid, 0);
        g.drawGrid(grid);
        System.out.println("-----------------------------");
        m.moveRight(grid, 1);
        g.drawGrid(grid);
        System.out.println("-----------------------------");
        m.moveUp(grid, 0);
        g.drawGrid(grid);
        System.out.println("-----------------------------");
        m.moveDown(grid, 1);
        g.drawGrid(grid);
    }

}
