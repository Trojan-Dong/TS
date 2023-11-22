package mapstruct;

import java.time.LocalDate;

public class Test {

    public static String getQuotaCode() {
        return "quotaCode0002";
    }

    public static Long getId(Long id) {
        return id*100;
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().minusDays(1));
        System.out.println(LocalDate.now().plusDays(1));
    }
}
