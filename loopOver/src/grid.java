public class grid{
    public int[][] getGrid(int len){
        int[][] g = new int[len][len];
        int counter = 1;
        for(int i = 0; i < g.length;i++){
            for(int j = 0; j < g[i].length; j++){
                g[i][j] = counter;
                counter++;
            }
        }
        return g;
    }

    public void drawGrid(int[][] g){
        for(int i = 0; i < g.length; i++){
            for(int j = 0; j < g[i].length; j++){
                System.out.print(g[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
    }

    public int[][] copy(int[][] g){
        int[][] m = new int[g.length][g.length];
        for(int i = 0 ; i < g.length; i++){
            for(int j = 0 ; j < g[i].length; j++){
                m[i][j] = g[i][j];
            }
        }
        return m;
    }
}