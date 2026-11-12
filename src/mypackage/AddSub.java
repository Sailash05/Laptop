package mypackage;

public class AddSub {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int unused = 100;

        System.out.println(a + b);

        // Duplicated code
        int x = 10;
        int y = 20;
        System.out.println(x + y);

        // Empty catch block
        try {
            int result = a / 0;
        } catch (Exception e) {
            
        }

        // Hardcoded password
        String password = "admin123";

        if (a == 10) {
            System.out.println("Hello");
        }
    }
}