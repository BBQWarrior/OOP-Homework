package fel_2;

public interface IDictionary {
    final String DICTIONARY_FILE = "lab8_2_input.txt";

    public boolean add(String word);

    public boolean find(String word);

    public int size();
}
