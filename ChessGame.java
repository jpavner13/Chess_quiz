public class ChessGame{

    private static Board board;

    public ChessGame(){
        board = new Board();
    }

    public static void main(String[] args){
        ChessGame game = new ChessGame();
        //placeRook(board.getSquare(4, 4));
        //placeKnight(board.getSquare(4, 4));
        //placeBishup(board.getSquare(4, 4));
        placeQueen(board.getSquare(4, 4));

        board.printBoard();
    }

    public static void placeRook(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        int rookInfluence = 0;
        
        for(int i = 1; i < 9; i++){ Board.getSquare(rank, i).toggleHighlighted(); rookInfluence++;}
        for(int i = 1; i < 9; i++){ Board.getSquare(i, file).toggleHighlighted(); rookInfluence++;}

        square.setPiece("r");
        
        Board.rookInfluence = rookInfluence;
    }

    public static void placeKnight(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        square.setPiece("k");

        int knightInfluence = 0;
        
        for(int rank2 = 1; rank2 < 9; rank2++){
            for(int file2 = 1; file2 < 9; file2++){
                Square square2 = board.getSquare(rank2, file2);
                if(square2.getRank() == rank + 2 || square2.getRank() == rank - 2){
                    if(square2.getFile() == file + 1 || square2.getFile() == file - 1){
                        board.getSquare(rank2, file2).toggleHighlighted();
                        knightInfluence++;
                    }
                }

                if(square2.getFile() == file + 2 || square2.getFile() == file - 2){
                    if(square2.getRank() == rank + 1 || square2.getRank() == rank - 1){
                        board.getSquare(rank2, file2).toggleHighlighted();
                        knightInfluence++;
                    }
                }
            }
        }
        Board.knightInfluence = knightInfluence;

    }

    public static void placeBishup(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        int bishupInfluence = 0;
        
        for(int row = 1; row < 9; row++){
            for(int col = 1; col < 9; col++){
                Square square2 = board.getSquare(row, col);

                for(int i = 1; i < 8; i++){
                    if((rank + i == square2.getRank() && file + i == square2.getFile()) || 
                        (rank - i == square2.getRank() && file - i == square2.getFile())||
                        (rank + i == square2.getRank() && file - i == square2.getFile())||
                        (rank - i == square2.getRank() && file + i == square2.getFile())){
                        square2.toggleHighlighted();
                        bishupInfluence++;
                    }
                }
            }
        }

        square.setPiece("Bi");
        
        Board.bishupInfluence = bishupInfluence;
    }

    public static void placeQueen(Square square){
        int rank = square.getRank();
        int file = square.getFile();

        int queenInfluence = 0;
        
        for(int row = 1; row < 9; row++){
            for(int col = 1; col < 9; col++){
                Square square2 = board.getSquare(row, col);

                for(int i = 1; i < 8; i++){
                    if((rank + i == square2.getRank() && file + i == square2.getFile()) || 
                        (rank - i == square2.getRank() && file - i == square2.getFile())||
                        (rank + i == square2.getRank() && file - i == square2.getFile())||
                        (rank - i == square2.getRank() && file + i == square2.getFile())){
                        if(square2.getColor().equals("B")||square2.getColor().equals("W")){
                            queenInfluence++;
                            square2.toggleHighlighted();
                        }    
                    }
                }
            }
            for(int i = 1; i < 9; i++){ 
                Square square2 = board.getSquare(rank, i);
                if(square2.getColor().equals("B")||square2.getColor().equals("W")){
                    queenInfluence++;
                    Board.getSquare(rank, i).toggleHighlighted(); 
                }    
            }
            for(int i = 1; i < 9; i++){ 
                Square square2 = board.getSquare(i, file);
                if(square2.getColor().equals("B")||square2.getColor().equals("W")){
                    queenInfluence++;
                    Board.getSquare(i, file).toggleHighlighted(); 
                }    
            }
        }

        square.setPiece("Q");
        
        Board.queenInfluence = queenInfluence;
    }
}