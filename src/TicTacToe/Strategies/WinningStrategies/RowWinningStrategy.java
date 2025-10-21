package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Moves;
import TicTacToe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol,Integer>> counts = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Moves moves) {
        int row = moves.getCells().getRow();
        Symbol symbol = moves.getPlayer().getSymbol();

        if(!counts.containsKey(row)){
            counts.put(row,new HashMap<>());
        }

        Map<Symbol,Integer> rowMap = counts.get(row);

        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol,0);
        }

        rowMap.put(symbol, rowMap.get(symbol)+1);

        if(rowMap.get(symbol).equals(board.getSize())){
            return true;
        }
        return false;
    }

    @Override
    public void undo(Board board, Moves moves) {
        int row = moves.getCells().getRow();
        Symbol symbol = moves.getPlayer().getSymbol();

        Map<Symbol,Integer> rowMap = counts.get(row);

        rowMap.put(symbol, rowMap.get(symbol)-1);


    }
}
