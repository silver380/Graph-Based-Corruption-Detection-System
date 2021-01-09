package IO;
import Graph.*;
import Graph.Vertex.*;
import Graph.Edge.*;

import java.util.*;
import javax.swing.*;
import java.io.*;


public class Input {
    public static final String[] filenames = {"accounts.csv", "calls.csv", "cars.csv", "homes.csv", "ownerships.csv",
            "people.csv", "phones.csv", "relationships.csv", "transactions.csv"};

    public static void getInput(Graph graph) {
        int current = 0;
        int all = filenames.length;

        JFileChooser fileChooser = new JFileChooser();
        while (current != all) {
            System.out.println("Please choose " + '"' + filenames[current] + '"' + " file");

            if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                System.out.println("Please choose the remaining files.(" + (all - current) + ") to go");
                continue;
            }

            File file = fileChooser.getSelectedFile();
            if (!file.getName().equals(filenames[current])) {
                System.out.println("Please choose the correct file.(" + filenames[current] + ")");
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

                    String[] split = row.split(",");

                    if (current == 0) {
                        graph.addVertex(new Accounts(split));
                    }
                    else if (current == 1) {
                        graph.addEdge(new Calls(split));
                    }
                    else if (current == 2) {
                        graph.addVertex(new Cars(split));
                    }
                    else if (current == 3) {
                        graph.addVertex(new Homes(split));
                    }
                    else if (current == 4) {
                        graph.addEdge(new Ownerships(split));
                    }
                    else if (current == 5) {
                        graph.addVertex(new People(split));
                    }
                    else if (current == 6) {
                        graph.addVertex(new Phones(split));
                    }
                    else if (current == 7) {
                        graph.addEdge(new Relationships(split));
                    }
                    else {
                        graph.addEdge(new Transactions(split));
                    }
                }
            } catch (IOException e) {
                System.out.println("CSV file is damaged.");
                continue;
            }

            current++;
        }
    }
}
