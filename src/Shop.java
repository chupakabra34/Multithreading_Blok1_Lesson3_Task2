import java.util.concurrent.atomic.LongAdder;

public class Shop {
    LongAdder money = new LongAdder();

    public void transfer(int dayOfMounth, String mounth, long diff) {
        System.out.printf("Магазин %s, выручка за %d %s, составила = %d \n", Thread.currentThread().getName(), dayOfMounth + 1,
                mounth, diff);
        money.add(diff);
    }

    public long storeSum() {
        return money.sum();
    }
}