package org.academiadecodigo.acd.ui;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Button {

    private int startX;
    private int startY;

    private int endX;
    private int endY;

    private Rectangle representation;

    public Button(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.representation = new Rectangle(startX, startY, 100, 20);
    }

    public boolean onHover(int mouseX, int mouseY){
        return (mouseX >= startX && mouseX <= endX) &&
                (mouseY >= startY && mouseY <= endY);
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Rectangle getRepresentation() {
        return representation;
    }

    public void setRepresentation(Rectangle representation) {
        this.representation = representation;
    }
}
