public class Rook{

    public void placeRook(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        square.setPiece("r");
        
        for(int rank2 = 0; rank2 < squares.length; rank2++){
            for(int file2 = 0; file2 < squares[0].length; rank2++){
                Square square2 = board.getSquare(rank2, file2);
                if(square2.getRank() == rank){
                    square.toggleHighlight();
                } else if (square2.getFile() == file){
                    square.toggleHighlight();
                }
            }
        }

        --------------------------------------------------------------

        for(int i = 0; i < squares.length; i++){ Board.getSquare(rank, i).toggleHighlight(); }
        for(int i = 0; i < squares[0].length; i++){ Board.getSquare(i, file).toggleHighlight(); }
    }
}