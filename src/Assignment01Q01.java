public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String s : args) {
            if (s != null && s.length() > 0) {
                char firstChar = s.charAt(0);
                if (s.charAt(0) % 5 == 0) {
                    System.out.println(firstChar);
                }
            }
        }
    }
}
