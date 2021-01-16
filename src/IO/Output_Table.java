package IO;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionListener;
import Graph.Algortihms.*;
import IO.Search.Trie;
import Graph.Vertex.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import Graph.*;


public class Output_Table {
    private static final String[] columns = {"Number", "ID", "Details"};
    private static int phase = 1;
    private static Trie trie = new Trie();
    private static JFrame frame = new JFrame("Information");
    private static JTextField textField = new JTextField();
    private static Graph graph = new Graph();
    private static JButton jButton;
    private static boolean draw;

    public static void show(Graph g, boolean drawGraph) {
        draw = drawGraph;
        frame.getContentPane().removeAll();
        graph = g;
        for(Vertex v : graph.getHashMap().values()) {
            trie.add(v.key);
        }
        jButton = new JButton("Phase: " + phase + "." + (phase == 4 ? "" : " Click to continue."));
        if (phase != 4)
            jButton.addActionListener(actionListener);

        textField.setSize(300, 40);
        textField.getDocument().addDocumentListener(listener);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(jButton, BorderLayout.SOUTH);
        System.out.println("we are here\n");
        draw("");

        if (phase == 1) {
            drawTheGraph();
        }
        if (phase == 2) {
            PhaseTwo.susFinder(graph);
            drawTheGraph();
        }
        else if (phase == 3) {
            PhaseThree.secondCheck(graph);
            drawTheGraph();
        }
        else if (phase == 4) {
            PhaseFour.thirdCheck(graph);
            drawTheGraph();
        }
    }

    private static void drawTheGraph() {
        if (draw)
            Output.draw(graph);
    }

    static ActionListener actionListener = e -> {
        phase++;
        show(graph, draw);
    };

    private static void draw(String search) {
        String[][] data;

        if (search.equals("sus2") || search.equals("sus3") || search.equals("sus4")) {
            ArrayList<String> ids = new ArrayList<>();
            ArrayList<String> vals = new ArrayList<>();

            int susValue = search.charAt(3) - '0' - 1;
            for(Vertex v : graph.getHashMap().values()) {
                if (v instanceof People && ((People) v).isSuspect == susValue) {
                    ids.add(v.key);
                    vals.add(v.toString());
                }
            }

            data = new String[ids.size()][3];
            for (int i = 0; i < ids.size(); i++) {
                data[i][0] = i + "";
                data[i][1] = ids.get(i);
                data[i][2] = vals.get(i);
            }
        }
        else {
            var list = trie.autoComplete(search);
            int size = list.size();
            data = new String[size][3];
            for (int i = 0; i < size; i++) {
                data[i][0] = i + "";
                data[i][1] = list.get(i);
                data[i][2] = graph.getHashMap().get(list.get(i)).toString();
            }
        }

        JTable jTable = new JTable(data, columns);
        jTable.getColumnModel().getColumn(0).setMinWidth(50);
        jTable.getColumnModel().getColumn(1).setMinWidth(80);
        jTable.getColumnModel().getColumn(2).setMinWidth(500);

        JScrollPane scrollPane = new JScrollPane(jTable);

        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(630, 400));
        frame.setVisible(true);
    }

    static DocumentListener listener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            frame.getContentPane().remove(2);
            draw(textField.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            frame.getContentPane().remove(2);
            draw(textField.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    };
}
