package TicTacToe.Strategies.BotPlayingStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Moves;

public interface BotPlayingStrategy {
    public Moves makeMove(Board board);

}
