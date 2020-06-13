package PaooGame.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*! \class MouseManager
    \brief Gestioneaza mouse input-ul
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    private boolean leftPressed;
    private boolean rightPressed;
    private int mouseX;
    private int mouseY;

    /*! \fn MouseManager()
        \brief Constructorul clasei
     */
    public MouseManager() {

    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
    }
}
