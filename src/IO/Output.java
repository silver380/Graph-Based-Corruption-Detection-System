package IO;

import Graph.Edge.Calls;
import Graph.Edge.Edge;
import Graph.Edge.Ownerships;
import Graph.Edge.Relationships;
import Graph.Graph;
import Graph.Vertex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Output extends Canvas {
    private static final Color c1 = new Color(255, 127, 80);
    private static final Color c2 = new Color(255, 215, 0);
    private static final Color c3 = new Color(118, 219, 117);
    private static final Color c4 = new Color(86, 121, 168);
    private static final Color c5 = new Color(191, 130, 191);
    private static final Color sus = new Color(214, 0, 45);
    private static final Color gh = new Color(20, 10, 20);

    private static final Color c6 = new Color(84, 42, 80);
    private static final Color c7 = new Color(20, 100, 59);
    private static final Color c8 = new Color(0, 34, 68);
    private static final Color c9 = new Color(110, 113, 113);

    private static final File file = new File("");

    private static int row, size, cSize = 30, margin = 10;
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private HashMap<String, Integer> vToIndex = new HashMap<>();
    private static JButton jButton;
    private static JFrame frame;
    private boolean isVertexSelected = false;
    private Vertex selectedVertex = null;
    private static JFrame jFrame;


    {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                // Todo uncomment
//                isVertexSelected = false;
//                repaint();
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

    private void showDialog(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    private static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(jButton.getActionListeners().length);
            System.out.println(e.getSource());
            System.out.println(jFrame);

            if (jFrame == null)
                jFrame = new JFrame("Guide");
            else
                jFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            JLabel label = new JLabel(new ImageIcon(file.getAbsolutePath() + "\\Files\\Guide.jpg"));
            jFrame.add(label);
            jFrame.setSize(400, 400);
            jFrame.pack();
            jFrame.setVisible(true);
        }
    };

    public static void draw(Graph graph) {
        jButton = new JButton("Guide");
        jButton.addActionListener(actionListener);

        if (frame != null)
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        frame = new JFrame("Graph");
        Output canvas = new Output();
        canvas.vertices = graph.getVertices();
        for (int i = 0; i < canvas.vertices.size(); i++) {
            canvas.vToIndex.put(canvas.vertices.get(i).key, i);
        }

        row = ((int) Math.ceil(Math.sqrt(canvas.vertices.size())));
        size = row * cSize;
        canvas.setSize(size, size);
        frame.add(canvas);
        frame.add(jButton, BorderLayout.SOUTH);
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
        XY from = getPos(vToIndex.get(v.key));
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
            if (((People) vertex).getWork().equals("قاچاقچی")) {
                g.setColor(gh);
            }
            else if (((People) vertex).isSuspect==1) {
                g.setColor(sus);
                extra = 4;
            }
            else if (((People) vertex).isSuspect==2) {
                g.setColor(sus);
                extra = 8;
            }
            else if (((People) vertex).isSuspect==3) {
                g.setColor(sus);
                extra = 12;
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

        if (vertex instanceof People && (((People) vertex).getWork().equals("قاچاقچی") || ((People) vertex).isSuspect == 3))
            g.fillRect(t.x * cSize + margin - extra / 2, t.y * cSize + margin - extra / 2, cSize - margin * 2 + extra, cSize - margin * 2 + extra);
        else
            g.fillOval(t.x * cSize + margin - extra / 2, t.y * cSize + margin - extra / 2, cSize - margin * 2 + extra, cSize - margin * 2 + extra);
    }

    public XY getPos (int index) {
        return new XY(index % row, index / row);
    }
}
