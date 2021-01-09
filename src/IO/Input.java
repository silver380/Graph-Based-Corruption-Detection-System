package IO;
import Graph.*;
import java.util.*;
import javax.swing.*;
import java.io.*;


public class Input {
    public static String[] filenames = {"accounts.csv", "calls.csv", "cars.csv", "homes.csv", "ownerships.csv",
            "people.csv", "phones.csv", "relationships.csv", "transactions.csv"};

    public static void getInput(Graph graph) {
        int current = 0;
        int all = filenames.length;

        JFileChooser fileChooser = new JFileChooser();
        while (current != all) {
            System.out.println("Please choose " + '"' + filenames[current] + '"' + "file");
            if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                System.out.println("Please choose the remaining files.(" + (all - current) + ") to go");
                continue;
            }

            File file = fileChooser.getSelectedFile();
            if (!file.getName().equals(filenames[current])) {
                System.out.println("Please choose the correct file.(" + filenames[current] + ")");
                continue;
            }

            ArrayList<String[]> list = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String row = "";
                while (true) {
                    row = reader.readLine();
                    if (row == null)
                        break;

                    list.add(row.split(","));
                }
            } catch (IOException f) {
                System.out.println("CSV file is damaged.");
                continue;
            }

            current++;

            for (String[] t : list) {
                for (String v : t) {
                    System.out.println(v);
                }
            }
//            TODO: add objects

//            graph.addVertex(null);
//            graph.addEdge(null);
        }
    }
}
