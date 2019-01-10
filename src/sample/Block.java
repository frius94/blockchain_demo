package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;

public class Block {

    private static int textX = 35;
    private static int textY = 250;
    private static int rectX = 10;
    private static int rectY = 200;
    private final int WIDTH = 250;
    private final int HEIGHT = 300;

    private long previousHash;
    private String transactions;

    private long blockHash;

    public Block(long previousHash, String transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;

        Object[] contens = {transactions.hashCode(), previousHash};
        this.blockHash = Arrays.hashCode(contens);
    }

    public long getPreviousHash() {
        return previousHash;
    }

    public String getTransaction() {
        return transactions;
    }

    public long getBlockHash() {
        return blockHash;
    }

    public void drawBlock(Canvas canvas) {
        Rectangle rectangle = new Rectangle(75, 50);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.fillRect(rectX, rectY, WIDTH, HEIGHT);
        gc.strokeText("Previous hash: " + Long.toString(this.getPreviousHash()), textX, textY);
        gc.strokeText("Block hash: " + Long.toString(this.getBlockHash()), textX, textY + 20);
        gc.strokeText("Transaction data: " + this.transactions, textX, textY + 40);
        gc.strokeLine(rectX + WIDTH, rectY + HEIGHT / 2, rectX + 350, rectY + HEIGHT / 2);
        rectX += 350;
        textX += 350;
    }
}
