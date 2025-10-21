package TicTacToe.models;

public class Cells {
    private int row;
    private int col;
    private CellsState cellsState;
    private Player player;

    public Cells(int row,int col){
        this.row = row;
        this.col = col;
        this.cellsState = CellsState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellsState getCellsState() {
        return cellsState;
    }

    public void setCellsState(CellsState cellsState) {
        this.cellsState = cellsState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
