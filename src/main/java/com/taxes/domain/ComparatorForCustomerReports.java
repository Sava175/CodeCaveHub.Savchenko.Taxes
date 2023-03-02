package com.taxes.domain;

import java.util.Comparator;

public class ComparatorForCustomerReports implements Comparator<Customer> {
    @Override
    public int compare(Customer first, Customer second) {
        int firstCustomer = first.getReports().size();
        int secondCustomer = second.getReports().size();
        return Integer.compare(firstCustomer, secondCustomer);
    }
}
