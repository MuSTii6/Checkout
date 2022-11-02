package ch.zhaw.checkout.checkout;

import java.util.List;

public class PercentageVoucher implements Voucher {

    private int discount = 0;

    public PercentageVoucher(int discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount(List<Product> products) {
        var totalPrice = products.stream().mapToDouble(p -> p.getPrice()).sum();
        return totalPrice * ((double) discount / 100);
    }

}
