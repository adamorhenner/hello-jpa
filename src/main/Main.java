package main;

import main.persistence.AuthorRepository;
import main.persistence.SubscriptionRepository;

import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SubscriptionRepository repository = new SubscriptionRepository();
//        Subscription s1 = new Subscription(null, new GregorianCalendar().getGregorianChange(), 10.9);
//        s1 = repository.create(s1);
//        System.out.println(s1.getId());
//
//        Subscription s2 = repository.findById(52L);
//        if (s2 != null) {
//            System.out.println("achou :D com valor: " + s2.getPayment());
//        } else {
//            System.out.println("não achou :(");
//        }
//
//
//        List<Subscription> subscriptions = repository.findAll();
//        for (Subscription s : subscriptions) {
//            System.out.println(s.getId() + " - " + s.getPayment());
//            if (s.getId() % 2 != 0) {
//                s = repository.delete(s.getId());
//                System.out.println("deletou: " + s.getId());
//            }
//        }

        List<Subscription> byPaymentLowerThan = repository.findByPaymentLowerThan(11.0);
        System.out.println(byPaymentLowerThan.size());


    }
        /*
        public static void main(String[] args) {
        AuthorRepository repository = new AuthorRepository();
//        Author a1 = new Author(null, "antonio", "robson");
//        a1 = repository.create(a1);
//        System.out.println(a1.getId());

        Author a2 = repository.findById(1L);
        if (a2 != null) {
            System.out.println("achou :D com nome: " + a2.getFirstName() + " " + a2.getLastName());
        } else {
            System.out.println("não achou :(");
        }
            System.out.println(a2.getFirstName() + a2.getLastName());
        Author a3 = repository.update(new Author(1L,"robson", "robson"));
            System.out.println(a3.getFirstName() + a3.getLastName());

            repository.delete(1L);
            Author a4 = repository.findById(1L);
            if (a4 != null) {
                System.out.println("achou :D com nome: " + a4.getFirstName() + " " + a4.getLastName());
            } else {
                System.out.println("não achou :(");
            }


/*
        Subscription s2 = repository.findById(52L);
        if (s2 != null) {
            System.out.println("achou :D com valor: " + s2.getPayment());
        } else {
            System.out.println("não achou :(");
        }


        List<Subscription> subscriptions = repository.findAll();
        for (Subscription s : subscriptions) {
            System.out.println(s.getId() + " - " + s.getPayment());
            if (s.getId() % 2 != 0) {
                s = repository.delete(s.getId());
                System.out.println("deletou: " + s.getId());
            }
        }
*/

}

