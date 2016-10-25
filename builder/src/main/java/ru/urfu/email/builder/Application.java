package ru.urfu.email.builder;

/**
 * Hello world!
 */
public class Application {
    public static void main(String[] args) {
        EmailBuilder emailBuilder = EmailBuilder.to("to@to.ru").content("Hello world").build();
        EmailBuilder emailBuilder2 = EmailBuilder.to("to@to.ru").content("Hello world").subject("subject").build();

        EmailBuilder emailBuilder3 = EmailBuilder.to("to@to.ru").content("Hello world").subject("subject")
                .copyTo("copyto@copyto.ru").build();
        EmailBuilder emailBuilder4 = EmailBuilder.to("to@to.ru").content("Hello world").from("test@test.ru").build();

        EmailBuilder emailBuilder5 = EmailBuilder.to("to@to.ru").content("Hello world").subject("subject")
                .copyTo("copyto@copyto.ru").copyTo("copyto2@copyto2.ru").build();

        System.out.println(emailBuilder.toString());
        System.out.println(emailBuilder2.toString());
        System.out.println(emailBuilder3.toString());
        System.out.println(emailBuilder4.toString());
        System.out.println(emailBuilder5.toString());
    }
}
