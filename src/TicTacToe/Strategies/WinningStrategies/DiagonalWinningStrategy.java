package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Moves;
import TicTacToe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    Map<Symbol,Integer> leftDiagonalMap = new HashMap<>();
    Map<Symbol,Integer> rightDiagonalMap = new HashMap<>();



    @Override
    public boolean checkWinner(Board board, Moves moves) {
        int row = moves.getCells().getRow();
        int col = moves.getCells().getCol();

        Symbol symbol = moves.getPlayer().getSymbol();

        if(row == col){
            if(!leftDiagonalMap.containsKey(symbol)){
                leftDiagonalMap.put(symbol,0);
            }
            leftDiagonalMap.put(symbol,leftDiagonalMap.get(symbol)+1);
            if(leftDiagonalMap.get(symbol).equals(board.getSize())){
                return true;
            }
        }

        if((row+col) == board.getSize()-1){
            if(!rightDiagonalMap.containsKey(symbol)){
                rightDiagonalMap.put(symbol,0);
            }
            rightDiagonalMap.put(symbol,rightDiagonalMap.get(symbol)+1);
            if(rightDiagonalMap.get(symbol).equals(board.getSize())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void undo(Board board, Moves moves) {
        int row = moves.getCells().getRow();
        int col = moves.getCells().getCol();

        Symbol symbol = moves.getPlayer().getSymbol();

        if(row == col){
            leftDiagonalMap.put(symbol,leftDiagonalMap.get(symbol)-1);
        }

        if((row+col) == board.getSize()-1){
            rightDiagonalMap.put(symbol,rightDiagonalMap.get(symbol)-1);
        }
    }
}
