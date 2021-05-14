package fel_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {
    IDictionary dictionary;

    public DictionaryService(DictionaryType type) {
        dictionary = DictionaryProvider.createDictionary(type);
    }

    public boolean findWord(String word) {
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
