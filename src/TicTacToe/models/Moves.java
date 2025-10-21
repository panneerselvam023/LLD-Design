package TicTacToe.models;

public class Moves {
    private Cells cells;
    private Player player;

    public Moves(Cells cells, Player player){
        this.cells = cells;
        this.player = player;
    }

    public Cells getCells() {

        return cells;
    }

    public void setCells(Cells cells) {
        this.cells = cells;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
