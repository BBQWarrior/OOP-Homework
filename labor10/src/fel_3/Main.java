package fel_3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileUtil.encode("README.md", "lab10_temp1.txt");
            FileUtil.decode("lab10_temp1.txt", "lab10_temp2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}