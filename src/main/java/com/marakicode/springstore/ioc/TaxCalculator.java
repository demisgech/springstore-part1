package com.marakicode.springstore.ioc;

public interface TaxCalculator {
    double calculateTax(double amount, double taxRate);
}
