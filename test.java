public class test {
    public static void main(String[] args) {
        char ch = 'A';
        boolean isAlphabet = ("" + ch).matches("[a-zA-Z]");
        System.out.println(ch + " is an alphabet: " + isAlphabet);
    }
}