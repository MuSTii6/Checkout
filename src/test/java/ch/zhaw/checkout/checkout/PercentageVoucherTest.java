package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PercentageVoucherTest {

    @Test
    public void testVoucher_withoutProducts() {
        var voucher = new PercentageVoucher(7);
        assertEquals(0, voucher.getDiscount(new ArrayList<Product>()), 0.01);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49, 50 })
    public void testVoucher_withoutProducts_multipleValues(int value) {
        var voucher = new PercentageVoucher(value);
        assertEquals(0, voucher.getDiscount(new ArrayList<Product>()), 0.01);
    }

    @Test
    public void testVoucher_withProducts() {
        var voucher = new PercentageVoucher(42);
        var product1 = new Product("id1", "Dunkle Schokolade", "A", 77);
        var product2 = new Product("id2", "Weisse Schokolade", "A", 42);

        assertEquals(49.98, voucher.getDiscount(Arrays.asList(product1, product2)), 0.01);
    }

}
