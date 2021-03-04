public class Main {

    public static void main(String[] args) {
        method(null);
        // null point exception  哈哈
    }

    public static void method(String param) {

        switch (param) {
            // 肯定不是进入这里
             case "sth":
               System.out.println("it's sth");
               break;             // 也不是进入这里
             case "null":
              System.out.println("it's null");
        }


    }
}