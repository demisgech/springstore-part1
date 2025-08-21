package com.marakicode.springstore.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TaxReport {
    private final TaxCalculator taxCalculator;

    @Autowired
    public TaxReport(@Qualifier("tax-2026") TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculateTax(double amount, double taxRate) {
        return taxCalculator.calculateTax(amount, taxRate);
    }
}
