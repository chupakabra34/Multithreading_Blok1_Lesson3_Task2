import java.util.concurrent.atomic.AtomicLong;

public class Shop {
    AtomicLong money = new AtomicLong(0);

    public void transfer(int dayOfMounth, String mounth, long diff) {
        System.out.printf("Магазин %s, выручка за %d %s, составила = %d \n", Thread.currentThread().getName(), dayOfMounth + 1,
                mounth, diff);
        money.addAndGet(diff);
    }

    public long storeSum() {
        return money.get();
    }
}