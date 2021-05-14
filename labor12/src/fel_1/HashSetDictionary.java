package fel_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetDictionary implements IDictionary {
    private HashSet<String> words = new HashSet<>();

    public HashSetDictionary() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DICTIONARY_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found: " + DICTIONARY_FILE);
            System.exit(1);
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }
    }

    public static IDictionary newInstance() {
        return new HashSetDictionary();
    }

    @Override
    public boolean add(String word) {
        if (find(word)) {
            System.out.println(word + "is already in the dictionary");
            return false;
        }
        words.add(word);
        return true;
    }

    @Override
    public boolean find(String word) {
        return words.contains(word);
    }

    @Override
    public int size() {
        return words.size();
    }
}
