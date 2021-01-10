import Graph.*;
import IO.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import Graph.Vertex.*;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Drawing.draw(graph);
//        IO.Input.getInput(graph);

    }
}

class Drawing extends Canvas {
    private static final Color c1 = new Color(255, 127, 80);
    private static final Color c2 = new Color(255, 215, 0);
    private static final Color c3 = new Color(118, 219, 117);
    private static final Color c4 = new Color(46, 56, 120);
    private static final Color c5 = new Color(91, 91, 91);
    private static int row, size, cSize = 30, margin = 10;
    private static ArrayList<Vertex> vertices = new ArrayList<>();

    {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() / cSize  + " " + e.getY() / cSize);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static class XY {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void draw(Graph graph) {
        JFrame frame = new JFrame("Graph");
        row = ((int) Math.ceil(Math.sqrt(200)));
        size = row * cSize;


        for (int i = 0; i < 200; i++) {
            int t = (int)(Math.random() * 4);
            if (t == 1)
                vertices.add(new People());
            else if (t == 2)
                vertices.add(new Homes());
            else if (t == 3)
                vertices.add(new Cars());
            else if (t == 4)
                vertices.add(new Phones());
            else
                vertices.add(new Accounts());
        }

        Drawing canvas = new Drawing();
        canvas.setSize(size, size);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        System.out.println(vertices.size());
        for (int i = 0; i < 200; i++) {
            drawCircle(g, vertices.get(i), i);
        }
    }

    public void drawCircle(Graphics g, Vertex vertex, int index) {
        XY t = getPos(index);
        if (vertex instanceof People) {
            g.setColor(c5);
        }
        else if (vertex instanceof Homes) {
            g.setColor(c4);
        }
        else if (vertex instanceof Phones) {
            g.setColor(c3);
        }
        else if (vertex instanceof Cars) {
            g.setColor(c2);
        }
        else if (vertex instanceof Accounts) {
            g.setColor(c1);
        }

        g.fillOval(t.x * cSize + margin, t.y * cSize + margin, cSize - margin * 2, cSize - margin * 2);
    }

    public XY getPos (int index) {
        return new XY(index % row, index / row);
    }
}
