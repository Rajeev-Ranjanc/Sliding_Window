package Sliding_Window.striver;

public class AllSubString_Generate {
    public static void main(String[] args) {
        String str = "abcabcbb";
        generateAllSubstring(str);
    }

    public static void generateAllSubstring(String s) {

        for (int i = 0; i < s.length(); i++) {

            String subStr = "";

            for (int j = i; j < s.length(); j++) {

                subStr += s.charAt(j);

            }
            System.out.println(subStr);
        }
    }
}
