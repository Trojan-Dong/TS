package dataType;

public class DataType {
    public static void main(String[] args) {
//        Integer i = new Integer("1");
        int a = 6;
        int b = 10;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
//        b = a ^ b ^ b;
////        a = a ^ b ^ a ^ b ^ b;

        System.out.println(a);
        System.out.println(100 ^ 888 ^ 888);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i" + i);
//            for (int j = 0; j < 10; j++) {
//                System.out.println("j" + j);
//                for (int k = 0; k < 10; k++) {
//                    System.out.println("k" + k);
//                    break;
//                }
//                return;
//            }
//        }


    }
}

