package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Strategies.WinningStrategies.ColumnWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;
import TicTacToe.models.*;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        try{
            int dimensions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L,"AB",new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2L,"gpt",new Symbol('O'),PlayerType.BOT,BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
                    Game game = gameController.startGame(dimensions,
                    players, winningStrategies);


            System.out.println("Game has been created");

             while (gameController.checkState(game).equals(GameState.In_PROGRESS)){
                 gameController.displayBoard(game);
                 System.out.println("Do you want to undo (Y/N)");
                 String  ans = scanner.next();
                 if(ans.equalsIgnoreCase("Y")){
                     gameController.undo(game);
                     continue;
                 }
                 gameController.makeMove(game);
             }

             if(gameController.checkState(game).equals(GameState.DRAW)){
                 System.out.println("Game has been draw");
             }
             if(gameController.checkState(game).equals(GameState.WIN)){
                 System.out.println("Game has been won by " + gameController.getWinner(game).getName());
             }
        }catch (Exception e){
            System.out.println("Something went wrong in creating the game "+e);
        }

    }
}
