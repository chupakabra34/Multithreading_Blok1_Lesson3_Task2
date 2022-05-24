/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 23.05.2022
 * \* ----- group JAVA-27 -----
 * \*
 * \* Description: Домашнее задание к занятию 1.3 Переменные многопоточной программы.
 * \*
 * \* Задача 2. Отчет для налоговой
 * \
 */

import java.util.*;

import static java.lang.System.out;

class Main {
    public static void main(String[] args) throws InterruptedException {
        String months[] = {"Янв", "Фев", "Мар", "Апр", "Май", "Июн", "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек"};
        final int REVENUE_MONTH = 10_000;
        GregorianCalendar gcalendar = new GregorianCalendar();
        String nameMonth = months[gcalendar.get(Calendar.MONTH)];
        int numberOfDaysInMonth = gcalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        final int amountFirstStore[] = new Random().ints(numberOfDaysInMonth, 0, REVENUE_MONTH).toArray();
        int amountSecondStore[] = new Random().ints(numberOfDaysInMonth, 0, REVENUE_MONTH).toArray();
        int amountThirdStore[] = new Random().ints(numberOfDaysInMonth, 0, REVENUE_MONTH).toArray();
        Shop shop = new Shop();
        for (int x = 0; x < numberOfDaysInMonth; x++) {
            int finalX = x;
            Thread thread1 = new Thread(null, () -> shop.transfer(finalX, nameMonth, amountFirstStore[finalX]), "Промтовары");
            Thread thread2 = new Thread(null, () -> shop.transfer(finalX, nameMonth, amountSecondStore[finalX]), "Всё для отдыха");
            Thread thread3 = new Thread(null, () -> shop.transfer(finalX, nameMonth, amountThirdStore[finalX]), "Охота и рыбалка");
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        }
        out.println("Итоговая выручка за месяц составила: " + shop.storeSum());

    }
}