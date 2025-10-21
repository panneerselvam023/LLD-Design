package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Cells;
import TicTacToe.models.Moves;
import TicTacToe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    Map<Integer,Map<Symbol,Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Moves moves) {
        int col = moves.getCells().getCol();
        Symbol symbol = moves.getPlayer().getSymbol();

        if(!counts.containsKey(col)){
            counts.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> colMap = counts.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }

        colMap.put(symbol, colMap.get(symbol)+1);

        if(colMap.get(symbol).equals(board.getSize())){
            return true;
        }
        return false;
    }

    @Override
    public void undo(Board board, Moves moves) {
        int col = moves.getCells().getCol();
        Symbol symbol = moves.getPlayer().getSymbol();


        Map<Symbol,Integer> colMap = counts.get(col);

        colMap.put(symbol, colMap.get(symbol)-1);


    }
}
