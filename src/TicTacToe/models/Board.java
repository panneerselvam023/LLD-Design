package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cells>> board;

    public Board(int dimension) {
        this.size = dimension;
        this.board = new ArrayList<>();

        for(int i=0;i< size;i++){
            board.add(new ArrayList<>());
            for (int j=0;j<size;j++){
                board.get(i).add(new Cells(i, j));
            }
        }
    }

    public void displayBoard() {
        for(List<Cells> row:board){
            for(Cells cells: row){
                if(cells.getPlayer() == null)
                System.out.print("| - |");
                else
                    System.out.print("| "+ cells.getPlayer().getSymbol().getaChar()+" |");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cells>> getCells() {
        return board;
    }

    public void setCells(List<List<Cells>> cells) {
        this.board = cells;
    }


}
