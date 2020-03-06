import java.awt.Color;

public class Square {

    private int rank, file;
    private String color = "B";
    private boolean isHighlighted = false;
    private String piece = null;

    public Square(int rank, int file, String color){
        this.rank = rank;
        this.file = file;
        this.color = color;
    }

    public void toggleHighlighted(){
        this.isHighlighted = !this.isHighlighted;
        this.color = "H";
    }
    public boolean isHighlighted(){
        this.color = "H";
        return this.isHighlighted;
    }

    public int getRank(){return this.rank;}
    public int getFile(){return this.file;}
    public String getColor(){return this.color;}

    public String getPiece(){return this.piece;}
    public void setPiece(String piece){
        this.color = piece;
    }
}