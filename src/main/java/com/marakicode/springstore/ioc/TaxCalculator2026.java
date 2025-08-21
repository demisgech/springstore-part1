package com.marakicode.springstore.ioc;

import org.springframework.stereotype.Service;

@Service("tax-2026")
public class TaxCalculator2026 implements TaxCalculator {
    @Override
    public double calculateTax(double amount, double taxRate) {
        System.out.println("Tax in 2026: ");
        return amount * taxRate;
    }
}
