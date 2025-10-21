package TicTacToe.models;

import TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Long id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel){
        super(id,name,symbol,playerType);
          this.botDifficultyLevel = botDifficultyLevel;
          this.botPlayingStrategy = BotPlayingStrategyFactory.gotBotPlayingStrategy(botDifficultyLevel);
    }

    public Moves makeMove(Board board){
      Moves moves = this.botPlayingStrategy.makeMove(board);
       moves.setPlayer(this);
       return moves;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
