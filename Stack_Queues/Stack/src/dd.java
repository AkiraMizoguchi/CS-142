public class dd {
    public static void main(String[] args) {

        System.out.println(mystery5("Hi, there!"));
//        String a="h";
//        System.out.println(a.substring(1, a.length() - 1));
    }

    public static int mystery1(int n) {
        if (n == 1)
            return n;
        else
            return n + mystery1(n - 1);
    }

    public static int mystery2(int n) {
        if (n < 10) {
            return n;
        } else

            return (n % 10) + mystery2(n / 10);
    }

    public static int mystery3(int n) {

        if (n == 0) {
            return 100;
        } else if (n == -1) {
            return 200;
        }
        if (n % 2 == 0) {

            return mystery3(n / 2);
        } else {
            return mystery3(n - 1);
        }
    }

    public static int mystery4(int b, int e) {

        if (e == 0) {
            return 1;
        } else {
            return b * mystery4(b, e - 1);
        }
    }

    public static String mystery5(String s) {
        if (s.length() == 0) {
            return "";
        } else {

            return "*" + mystery5(s.substring(1, s.length() - 1));
        }
    }

    public static boolean mystery7(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        } else {
            return mystery7(word.substring(1, word.length() - 1));
        }
    }
}
