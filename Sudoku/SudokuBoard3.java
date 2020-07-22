import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuBoard3 {
    public final int SIZE = 9;
    //field
    private int[][] board=new int[SIZE][SIZE];
    private BoardGUI boardGUI;
    //constructor//a constructor for this class that takes one String parameter
    public SudokuBoard3(String path,BoardGUI boardGui) throws FileNotFoundException {
        boardGUI=boardGui;
        Scanner input=new Scanner(new File(path));
        for(int row = 0; row < SIZE; row++){
            String line=input.nextLine();
            for(int column=0; column < SIZE;column++){
                if(line.charAt(column)=='.') {
                    board[row][column] = 0;
                }else{
                    board[row][column]=Character.getNumericValue(line.charAt(column));
                }
            }
        }
    }

    //toString
    public String toString(){
        String newStr="";
        for(int row =0;row<SIZE;row++){
            for(int column=0; column<SIZE;column++) {
                if(column==3||column==6){
                    newStr+="  ";
                }
                if(board[row][column]==0){
                    newStr += " _";
                }else {
                    newStr += " "+board[row][column];
                }
            }
            newStr+="\n";
            if(row==2||row==5){
                newStr+="\n";
            }
        }
        return newStr;
    }

    public boolean isValid(){
        //check all situation
        return CheckingValidData()&&CheckingRows()&&CheckingColumns()&&CheckingMiniSquares();
    }

    //privateHelper
    //there is no data in the board that is not a 1-9 or a space
    private boolean CheckingValidData(){
        Integer[] validNum={0,1,2,3,4,5,6,7,8,9};
        Set<Integer> set=new HashSet<>(Arrays.asList(validNum));
        for(int row=0;row<SIZE;row++){
            for(int column=0; column<SIZE; column++){
                if(!(set.contains(board[row][column]))){
                    return false;
                }
            }
        }
        return true;
    }

    //this method will check the row whether there is a duplicate value or not
    private boolean CheckingRows(){
        Set<Integer> set=new HashSet<>();
        for(int row=0;row<SIZE;row++){
            for(int column=0; column<SIZE; column++){
                if(board[row][column]!=0&&set.contains(board[row][column])){
                    return false;
                }
                set.add(board[row][column]);
            }
            set.clear();
        }
        return true;
    }

    //this method will check the column whether there is a duplicate value or not
    private boolean CheckingColumns(){
        Set<Integer> set= new HashSet<>();
        for(int column=0;column<SIZE;column++){
            for(int row=0;row<SIZE;row++){
                //check the value in the set or not before add the set.
                if(board[row][column]!=0&&set.contains(board[row][column])){
                    return false;
                }
                set.add(board[row][column]);
            }
            set.clear();
        }
        return true;
    }

    //this method will check MiniSquares whether there is a duplicate value or not.
    private boolean CheckingMiniSquares(){
        Set<Integer> set= new HashSet<>();
        for(int i=1; i<=9;i++){
            int[][] mini=miniSquare(i);
            for(int row=0;row<3;row++){
                for(int column=0;column<3;column++){
                    if(mini[row][column]!=0&&set.contains(mini[row][column])){
                        return false;
                    }
                    set.add(mini[row][column]);
                }
            }
            set.clear();
        }
        return true;

    }

    private int[][] miniSquare(int spot) {
        int[][] mini = new int[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                // whoa - wild! This took me a solid hour to figure out (at least)
                // This translates between the "spot" in the 9x9 Sudoku board
                // and a new mini square of 3x3

                mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
            }
        }
        return mini;
    }


    //This method will check the square is correct or not
    public boolean isSolved(){
        if(!(isValid())){
            return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int row=0;row<SIZE;row++){
            for(int column=0;column<SIZE;column++){
                if(board[row][column]==0){
                    return false;
                }
                if(map.get(board[row][column])==null){
                    map.put(board[row][column],1);
                } else {
                    map.put(board[row][column], map.get(board[row][column])+1);
                }
            }
        }
        for(int numInMap :map.values()){
            if(numInMap!=9){
                return false;
            }
        }
        return true;
    }

    //this method find solution of the board based on backtracking
    public boolean solve(){
        boardGUI.update(board);
        if(!(isValid())){
            return false;
        }
        if(isSolved()){
            return true;
        }
        for(int row=0;row<SIZE;row++){
            for(int column=0;column<SIZE;column++){
                if(board[row][column]==0){
                    for(int i=1;i<=SIZE;i++){
                        board[row][column]=i;
                        if(isValid()){
                            solve();
                        }
                        if(isSolved()){
                            return true;
                        }
                        board[row][column]=0;
                    }
                }
            }
        }
        return false;
    }

}
