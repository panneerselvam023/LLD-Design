package TicTacToe.Strategies.BotPlayingStrategies;

import TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy gotBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new easyBotPlayingStrategy();
        }
        if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new mediumBotPlayingStrategy();
        }

        return new easyBotPlayingStrategy();
    }
}
