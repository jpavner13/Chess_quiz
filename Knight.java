public class Knight{

    public void placeKnight(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        square.setPiece("k");
        
        for(int rank2 = 0; rank2 < squares.length; rank2++){
            for(int file2 = 0; file2 < squares[0].length; rank2++){
                Square square2 = board.getSquare(rank2, file2);
                if(square2.getRank() == rank + 2 || square2.getRank() = rank - 2){
                    if(square2.getFile() == file + 1 || square2.getFile() == file - 1){
                        square2.toggleHighlight();
                    }
                }

                if(square2.getFile() == file + 2 || square2.getFile() = file - 2){
                    if(square2.getRank() == rank + 1 || square2.getRank() == rank - 1){
                        square2.toggleHighlight();
                    }
                }
            }
        }

    }
}