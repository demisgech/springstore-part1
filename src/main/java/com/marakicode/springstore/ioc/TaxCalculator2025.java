package com.marakicode.springstore.ioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("tax-2025")
@Primary
public class TaxCalculator2025 implements TaxCalculator {
    public double calculateTax(double amount, double taxRate) {
        System.out.println("Tax in 2025: ");
        return amount * taxRate;
    }
}
