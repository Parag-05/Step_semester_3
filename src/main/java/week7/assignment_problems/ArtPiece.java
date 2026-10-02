package main.java.week7.assignment_problems;

public abstract class ArtPiece {
    private static int counter = 1001;
    private final String pieceId;
    protected String title;

    public ArtPiece(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title;
        this.pieceId = "ART-" + counter++;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}