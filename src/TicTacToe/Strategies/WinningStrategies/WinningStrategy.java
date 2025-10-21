package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Moves;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Moves moves);

     public void undo(Board board, Moves move);
}
