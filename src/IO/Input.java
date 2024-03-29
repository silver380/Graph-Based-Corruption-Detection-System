package IO;
import Graph.*;
import Graph.Vertex.*;
import Graph.Edge.*;

import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
import java.io.*;


public class Input {
    public static final String[] filenames = {"accounts.csv", "cars.csv", "homes.csv", "people.csv", "phones.csv",
            "relationships.csv", "transactions.csv", "calls.csv", "ownerships.csv"};

    public static void getInput(Graph graph) {
        int current = 0;
        int all = filenames.length;
        JFrame jFrame = new JFrame("File's Order Guide");
        File f1 = new File("");

        JLabel label = new JLabel(new ImageIcon(f1.getAbsolutePath() + "\\Files\\Guide1.jpg"));
        jFrame.add(label);
        jFrame.setSize(400, 400);
        jFrame.pack();
        jFrame.setVisible(true);

        JFileChooser fileChooser = new JFileChooser();

        while (current != all) {
            System.out.println("Please choose " + '"' + filenames[current] + '"' + " file");

            if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                showDialog("Please choose the remaining files.(" + (all - current) + ") to go");
                continue;
            }

            File file = fileChooser.getSelectedFile();
            if (!file.getName().equals(filenames[current])) {
                showDialog("Please choose the correct file.(" + filenames[current] + ")");
                continue;
            }

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                reader.readLine();
                String row = "";

                while (true) {
                    row = reader.readLine();

                    if (row == null)
                        break;

                    String[] split = row.replaceAll("\"", "").split(",");

                    if (current == 0) {
                        graph.addVertex(new Accounts(split));
                    }
                    else if (current == 1) {
                        graph.addVertex(new Cars(split));
                    }
                    else if (current == 2) {
                        graph.addVertex(new Homes(split));
                    }
                    else if (current == 3) {
                        graph.addVertex(new People(split));
                    }
                    else if (current == 4) {
                        graph.addVertex(new Phones(split));
                    }
                    else if (current == 5) {
                        graph.addEdge(new Relationships(split));
                    }
                    else if (current == 6) {
                        graph.addEdge(new Transactions(split));
                    }
                    else if (current == 7) {
                        graph.addEdge(new Calls(split));
                    }
                    else {
                        graph.addEdge(new Ownerships(split));
                    }
                }
            } catch (IOException e) {
                showDialog("CSV file is damaged.");
                continue;
            }

            current++;
        }
        jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
    }

    private static void showDialog(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
