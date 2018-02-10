package org.academiadecodigo.acd.ui;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class UITowerSelector implements MouseHandler{

    private Mouse mouse;

    private Button button;
    private int mouseX, mouseY;

    public UITowerSelector(){
        this.button = ButtonFactory.build(10, 10, 10, 10);
        this.mouse = new Mouse(this);
    }

    public void draw(){
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        button.getRepresentation().fill();

        if(button.onHover(mouseX, mouseY)){
            System.out.println("Clicking");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = (int) e.getX();
        mouseY = (int) e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
