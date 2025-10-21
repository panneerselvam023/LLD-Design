package TicTacToe.Strategies.BotPlayingStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Cells;
import TicTacToe.models.CellsState;
import TicTacToe.models.Moves;

import java.util.List;

public class easyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Moves makeMove(Board board) {
       for(List<Cells> row: board.getCells()){
           for(Cells cells:row){
               if(cells.getCellsState().equals(CellsState.EMPTY)){
                   return new Moves(cells,null);
               }
           }
       }
       return null;
    }
}
