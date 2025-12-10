package se.hig.aod.lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BSTstudy_shuffle {
    public static void main(String[] args) throws Exception {
        String path = "unique_integers.txt";

        List<Integer> elementsToSearchFor = loadListFromFile(path, 2_500_000);

        int[] sizes = { 10_000, 20_000, 40_000, 80_000,
                160_000, 320_000, 640_000,
                1_280_000, 2_560_000 };

        System.out.println("N\tTime(ms)");

        for (int N : sizes) {

            long totalTime = 0;
            int repeats = 10; // Loopen ska köras 10 gånger

            for (int i = 0; i < repeats; i++) {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>();

                List<Integer> dataList = loadListFromFile(path, N); // Skapar en List med N antal element

                Collections.shuffle(dataList); // Blanda alla element

                for (int X : dataList) { // För varje element i dataList
                    bst.addElement(X); // Lägg in de i de binära sökträdet
                }

                long t1 = System.currentTimeMillis(); // Mät tiden

                for (int A : elementsToSearchFor) { // För varje element i elementsToSearchFor
                    bst.searchElement(A); // Sök upp de elementet i sökträdet
                }

                long t = System.currentTimeMillis() - t1; // Hämta tiden
                totalTime += t;

            }
            long avgTime = totalTime / 10;
            System.out.println(N + "\t" + avgTime);
        }

    }

    private static List<Integer> loadListFromFile(String path, int size) throws FileNotFoundException, IOException {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;

        try (Scanner in = new Scanner(new FileReader(path))) {
            while (cnt < size && in.hasNextLine()) {
                String line = in.nextLine();
                try {
                    list.add(Integer.parseInt(line));
                    cnt++;
                } catch (NumberFormatException nfe) {
                    System.err.printf("Not an integer while reading from data file\"%s\": %s (ignoring)%n", path,
                            nfe.getLocalizedMessage());
                }

            }
        }
        if (cnt != size) {
            System.err.printf("Didnt't read %d integers, only %d.%n", size, cnt);
        }
        return list;
    }
}
