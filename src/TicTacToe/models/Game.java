package TicTacToe.models;

import TicTacToe.Exception.BotCountException;
import TicTacToe.Exception.SymbolCountException;
import TicTacToe.Exception.playerCountException;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
   private List<Player> player;
   private Board board;
   private List<Moves> moves;
   private GameState gameState;
   private Player winner;
   private int NextPlayerIndex;
   private List<WinningStrategy> winningStrategies;

   private Game(int dimension, List<Player> players,List<WinningStrategy> winningStrategies){
       board = new Board(dimension);
       this.player = players;
       this.winningStrategies = winningStrategies;
       this.moves = new ArrayList<>();
       this.gameState = GameState.In_PROGRESS;
       this.NextPlayerIndex = 0;
   }
   public static Builder getBuilder(){
       return new Builder();
   }

    public void displayBoard() {
       this.board.displayBoard();
    }

    public void makeMove() {
       Player currentPlayer = player.get(NextPlayerIndex);
        System.out.println("It is " +currentPlayer.getName() +"'s move");
        Moves move = currentPlayer.makeMove(board);

        System.out.println(currentPlayer.getName()+" has made a move" + move.getCells().getRow()+", "+move.getCells().getCol());
        if(!validateMove(move)){
            return;
        }

        int row = move.getCells().getRow();
        int col = move.getCells().getCol();

        Cells actualCellOfBoard = board.getCells().get(row).get(col);
        actualCellOfBoard.setCellsState(CellsState.FILLED);
        actualCellOfBoard.setPlayer(currentPlayer);
        Moves actualMove = new Moves(actualCellOfBoard,currentPlayer);
        moves.add(actualMove);

        NextPlayerIndex += 1;
        NextPlayerIndex %= player.size();

        if(checkWinner(move)){
            setGameState(GameState.WIN);
            setWinner(currentPlayer);
            return;
        }
        if(moves.size() == board.getSize() * board.getSize()){
            setGameState(GameState.DRAW);
            System.out.println("Game has been drawn ");
        }
    }

    public boolean checkWinner(Moves moves){
         for(WinningStrategy winningStrategy: winningStrategies){
             if(winningStrategy.checkWinner(board, moves)){
                 return true;
             }
         }
        return false;
    }

    public boolean validateMove(Moves moves){
       int row = moves.getCells().getRow();
       int col = moves.getCells().getCol();
       if(row<0 || row>=board.getSize()){
           return false;
       }
       if(col<0 || col>=board.getSize()){
           return false;
       }

       if(board.getCells().get(row).get(col).getCellsState().equals(CellsState.FILLED)){
         return false;
       }
    return true;

    }

    public void undo(){
       if(moves.size() == 0)
           return;
         Moves lastMove = moves.get(moves.size()-1);
         moves.remove(moves.size()-1);

         Cells cells = lastMove.getCells();
         cells.setPlayer(null);
         cells.setCellsState(CellsState.EMPTY);

         for(WinningStrategy winningStrategy : winningStrategies){
             winningStrategy.undo(board, lastMove);
         }

         NextPlayerIndex -= 1;
         NextPlayerIndex = (NextPlayerIndex + player.size()) % player.size();
   }

    public static class Builder{
       private int dimensions;
       private List<Player> player;
       private List<WinningStrategy> winningStrategies;

       public Game build() throws BotCountException, SymbolCountException, playerCountException {
           validate();
           return new Game(dimensions,player,winningStrategies);
       }
       private void validate() throws playerCountException, BotCountException, SymbolCountException {
           validatePlayerCount();
           validateBotCount();
           validateSymbolCount();
       }

       private void validatePlayerCount() throws playerCountException {
           if(player.size()!=dimensions-1){
               throw new playerCountException();
           }

       }

       private void validateBotCount() throws BotCountException {
           int countOfBot = 0;
         for(Player players : player){
            if(players.getPlayerType().equals(PlayerType.BOT)){
                countOfBot++;
            }
         }

         if(countOfBot>1){
             throw new BotCountException();
         }
       }

       private void validateSymbolCount() throws SymbolCountException {
           Map<Character,Integer> symbolCount = new HashMap<>();
           for(Player players : player){
               if(!symbolCount.containsKey(players.getSymbol().getaChar())){
                   symbolCount.put(players.getSymbol().getaChar(),0);
               }
               symbolCount.put(players.getSymbol().getaChar(),symbolCount.get(players.getSymbol().getaChar())+1);
           if(symbolCount.get(players.getSymbol().getaChar())>1){
               throw new SymbolCountException();
           }
           }

       }
       public Builder setDimensions(int dimensions) {
           this.dimensions = dimensions;
           return this;
       }


       public Builder setPlayer(List<Player> player) {
           this.player = player;
           return this;
       }

       public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
           this.winningStrategies = winningStrategies;
           return this;
       }
   }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return NextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        NextPlayerIndex = nextPlayerIndex;
    }
}
