import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
        static Random number = new Random();
        static ArrayList<String> storage = new ArrayList<>();
        static grid  Grid = new grid();
        static moves m = new moves();
        static int [][] or;
    public static void main(String args[]){
        System.out.print("Enter len: ");
        int len = (new Scanner(System.in).nextInt());
        if(len == 1){
            do{
                System.out.print("len must be > 1");
                len = (new Scanner(System.in).nextInt());
            }
            while(len == 1);
        }

        int[][] g = Grid.getGrid(len);
        shuffle(g);
        or = Grid.copy(g);
        Grid.drawGrid(g);


        System.out.println("w - up, s - down, a - left, d-right\n0 - 1st col/row, 1 - 2nd col/row, 2 - 3rd col/row\nfor example to move 1st colomn up you type \'0w\' then press enter.\nstart counting at 0\n(q)uite to quite\n(s)olve to solve."); 
        while(true){
            System.out.print(": ");
            String move = (new Scanner(System.in).nextLine()).toLowerCase();
            if(move.charAt(0) == 'q'){
                System.out.println("Thanks for playing");
                break;
            }
            if(move.charAt(0) == 's'){
                solve(g);
                break;
            }
            moving(move, g);
            Grid.drawGrid(g);
        }

    }

    public static void moving(String move, int[][] g){
        char type = move.charAt(1);
            int where = Integer.parseInt(""+move.charAt(0));
            if(type == 's'){
                m.moveUp(g, where);
            }
            else if(type == 'w'){
                m.moveDown(g, where);
            }
            else if(type == 'a'){
                m.moveLeft(g, where);
            }
            else if(type == 'd'){
                m.moveRight(g, where);
            }

    }
    public static String oppose(String move){
        char m = move.charAt(1);
        if(m == 'w'){
            move = move.replace('w','s');
        }
        else if(m == 's'){
            move = move.replace('s','w');
        }
        else if(m == 'a'){
            move = move.replace('a','d');
        }
        if(m == 'd'){
            move = move.replace('d','a');
        }
        return move;
    }

    public static void solve(int[][] g){
        Grid.drawGrid(or);
        for(int i = 0 ; i < storage.size(); i++){
            System.out.println("move: "+storage.get(i));
            moving(oppose(storage.get(i)), or);
            Grid.drawGrid(or);
        }
    }

    public static void shuffle(int[][] grid){
        int max = number.nextInt(5, 11);
        String[] mm = {"w","a","d","s"};
        for(int i = 0; i < max; i++){
            int move = number.nextInt(0,grid.length);
            String mmm = mm[number.nextInt(4)];
            storage.add(0,move+mmm);
            moving(move+mmm,grid);
        }
    }
}
