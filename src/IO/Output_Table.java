package IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Graph.Algortihms.*;
import Graph.Vertex.*;
import Graph.*;
import IO.Search.Trie;


public class Output_Table {
    private static final String[] columns = {"ID", "Details"};
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
            // Todo complete
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

            data = new String[ids.size()][2];
            for (int i = 0; i < ids.size(); i++) {
                data[i][0] = ids.get(i);
                data[i][1] = vals.get(i);
            }
        }
        else {
            var list = trie.autoComplete(search);
            int size = list.size();
            data = new String[size][2];
            for (int i = 0; i < size; i++) {
                data[i][0] = list.get(i);
                data[i][1] = graph.getHashMap().get(list.get(i)).toString();
            }
        }

        JTable jTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(jTable);

        frame.add(scrollPane);
        frame.setMinimumSize(new Dimension(300, 400));
        frame.pack();
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
