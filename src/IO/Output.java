package IO;

import Graph.Edge.Calls;
import Graph.Edge.Edge;
import Graph.Edge.Ownerships;
import Graph.Edge.Relationships;
import Graph.Graph;
import Graph.Vertex.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Output extends Canvas {
    private static final Color c1 = new Color(255, 127, 80);
    private static final Color c2 = new Color(255, 215, 0);
    private static final Color c3 = new Color(118, 219, 117);
    private static final Color c4 = new Color(86, 121, 168);
    private static final Color c5 = new Color(191, 130, 191);
    private static final Color sus = new Color(214, 0, 45);

    private static final Color c6 = new Color(52, 22, 5);
    private static final Color c7 = new Color(23, 46, 0);
    private static final Color c8 = new Color(0, 42, 58);
    private static final Color c9 = new Color(53, 37, 54);


    private static int row, size, cSize = 30, margin = 10;
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private HashMap<String, Integer> vToIndex = new HashMap<>();

    private boolean isVertexSelected = false;
    private Vertex selectedVertex = null;

    {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() / cSize  + " " + e.getY() / cSize);
                isVertexSelected = true;
                selectedVertex = vertices.get((e.getY() / cSize) * row + e.getX() / cSize);
                repaint();
                showDialog(selectedVertex.toString());
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
                isVertexSelected = false;
                repaint();
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

    public void showDialog(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void draw(Graph graph) {
        JFrame frame = new JFrame("Graph");
        Output canvas = new Output();
        canvas.vertices = graph.getVertices();
        for (int i = 0; i < canvas.vertices.size(); i++) {
            canvas.vToIndex.put(canvas.vertices.get(i).getKey(), i);
        }

        row = ((int) Math.ceil(Math.sqrt(canvas.vertices.size())));
        size = row * cSize;

        canvas.setSize(size, size);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
        g.setStroke(new BasicStroke(1));
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(rh);

        if (!isVertexSelected)
            drawAllEdges(g);
        else
            drawEdges(g, selectedVertex);

        for (int i = 0; i < vertices.size(); i++) {
            drawCircle(g, vertices.get(i), i);
        }
    }

    public void drawAllEdges(Graphics2D g) {
        for (Vertex v : vertices) {
            drawEdges(g, v);
        }
    }

    public void drawEdges(Graphics2D g, Vertex v) {
        XY from = getPos(vToIndex.get(v.getKey()));
        for (Edge edge : v.edges) {
            XY to = getPos(vToIndex.get(edge.to));
            Color color;
            if (edge instanceof Calls)
                color = c6;
            else if (edge instanceof Ownerships)
                color = c7;
            else if (edge instanceof Relationships)
                color = c8;
            else
                color = c9;

            drawEdge(g, from, to, color, isVertexSelected);
        }
    }

    private void drawEdge(Graphics2D g, XY from, XY to, Color color, boolean bold) {
        g.setColor(color);
        if(bold)
            g.setStroke(new BasicStroke(3));
        g.drawLine(to.x * cSize + margin + (cSize - 2 * margin) / 2, to.y * cSize + margin + (cSize - 2 * margin) / 2,
                from.x * cSize + margin + (cSize - 2 * margin) / 2, from.y * cSize + margin + (cSize - 2 * margin) / 2);
    }

    public void drawCircle(Graphics2D g, Vertex vertex, int index) {
        int extra = 0;
        XY t = getPos(index);
        if (vertex instanceof People) {
            if (((People) vertex).isSuspect) {
                g.setColor(sus);
                extra = 5;
            }
            else
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

        g.fillOval(t.x * cSize + margin - extra / 2, t.y * cSize + margin - extra / 2, cSize - margin * 2 + extra, cSize - margin * 2 + extra);
    }

    public XY getPos (int index) {
        return new XY(index % row, index / row);
    }
}
