package fel_3;

public class Main {
    public static void main(String[] args) {
        Process process = new Process("lab12-3-inputs/nevek1.txt");
        process.setHuLit("lab12-3-inputs/magyar.txt");
        process.setRoLit("lab12-3-inputs/roman.txt");
        process.setMath("lab12-3-inputs/matek.txt");
        System.out.println("Passed: " + process.numStudentsPassed());
        process.printFailed(System.out);
    }
}
