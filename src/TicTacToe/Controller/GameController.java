package TicTacToe.Controller;

import TicTacToe.Exception.BotCountException;
import TicTacToe.Exception.SymbolCountException;
import TicTacToe.Exception.playerCountException;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;
import TicTacToe.models.Board;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimensions,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws BotCountException, SymbolCountException, playerCountException {

        return Game.getBuilder().setDimensions(dimensions)
                .setPlayer(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void displayBoard(Game game){
         game.displayBoard();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game){
             game.undo();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
