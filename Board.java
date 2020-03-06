public class Board {

    private static Square[][] squares;

    public static int rookInfluence   = 0;
    public static int knightInfluence = 0;
    public static int bishupInfluence = 0;
    public static int queenInfluence  = 0;

    public Board(){
        squares = new Square[8][8];

        for(int row = 0; row < squares.length; row++){
            boolean isBlack = false;
            if(row % 2 == 0){
                isBlack = true;
            }
            for(int col = 0; col < squares[row].length; col++){
                    int file = col + 1;
                    int rank = squares.length - row;
                    String color = "W";
                if (isBlack){
                    color = "B";
                }

                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public void printBoard(){
        for(int row = 0; row < squares.length; row++){
            System.out.println("\n");
            for(int col = 0; col < squares[row].length; col++){
                System.out.print("   " + squares[row][col].getColor());
            }
        }
        System.out.println("\n");
        System.out.println("\tRook Influence = " + (this.rookInfluence - 2));
        System.out.println("\tKnight Influence = " + (this.knightInfluence));
        System.out.println("\tBishup Influence = " + (this.bishupInfluence));
        System.out.println("\tQueen Influence = " + (this.queenInfluence));

    }

    public static Square getSquare(int rank, int file){
        return squares[8 - rank][file - 1];
    }

    public static int getLength(){
        return squares.length;
    }
}