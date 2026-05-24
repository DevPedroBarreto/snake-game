package painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.*;

public class Painel extends JPanel implements KeyListener {
    public Painel(){
        setBackground(Color.black);
        Timer timer = new Timer(100, e -> {
            MoveSnake();
            repaint();
        });
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }


    private int SnakeX = 240;
    private int SnakeY = 250;

    private String direction = "RIGHT";


    public void MoveSnake() {
            if(direction.equals("RIGHT")) {
                SnakeX += 10;
            }
            if (direction.equals("LEFT")) {
                SnakeX -= 10;
            }
            if(direction.equals("UP")) {
                SnakeY -= 10;
            }
            if(direction.equals("DOWN")){
                SnakeY += 10;
            }
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.green);
        int AppleX = 100;
        int Appley = 30;
        int AppleSizeX = 20;
        int AppleSizeY = 20;
        g.fillOval(AppleX, Appley, AppleSizeX, AppleSizeY);

        g.setColor(new Color(0xE24406));
        int SnakeSizeY = 20;
        int SnakeSizeX = 20;
        g.fillRect(SnakeX,SnakeY,SnakeSizeX,SnakeSizeY);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction = "RIGHT";
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = "LEFT";
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            direction = "UP";
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction = "DOWN";
        }
    }

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}

}
