package painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.util.Random;

public class Painel extends JPanel implements KeyListener {
    public Painel(){
        setBackground(Color.black);
        Timer timer = new Timer(100, e -> {
            MoveSnake();
            Colision();
            repaint();
        });
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    private Random random = new Random();

    private int SnakeX = 240;
    private int SnakeY = 250;

    private String direction = "RIGHT";

    private int AppleX = 100;
    private int Appley = 30;

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

        if (SnakeX >= 1000){
                SnakeX = 0;
        } else if (SnakeX <= 0) {
                SnakeX = 990;
        } else if (SnakeY >= 1000) {
                SnakeY = 0;
        } else if (SnakeY <= 0) {
            SnakeY = 990;
        }
    }

    public void Colision(){
        if (SnakeX == AppleX &&  SnakeY == Appley){
            AppleX =  random.nextInt(100) * 10;
            Appley =  random.nextInt(100) * 10;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.green);

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
