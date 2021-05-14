package fel_1;

public class DictionaryProvider {
    public static IDictionary createDictionary(DictionaryType type) {
        IDictionary dictionary = null;
        switch (type) {
            case ARRAY_LIST:
                dictionary = ArrayListDictionary.newInstance();
                break;
            case HASH_SET:
                dictionary = HashSetDictionary.newInstance();
                break;
            case TREE_SET:
                dictionary = TreeSetDictionary.newInstance();
                break;
        }
        return dictionary;
    }
}
