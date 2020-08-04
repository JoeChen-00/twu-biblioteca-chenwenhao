package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    private Customer customer;
    private Customer libraren;

    @Before
    public void setUp() {
        this.libraren = new Customer("Joe","123456","libraren","wenhao.chen@thoughtworks.com","15907130615",true);
        this.customer = new Customer("Joechen01","123456","customer","wenhao.chen@thoughtworks.com","15907130615",false);
    }

    @Test
    public void getNameShouldReturnName(){
        String customerName = this.customer.getUserName();
        String librarenName = this.libraren.getUserName();
        assertThat(customerName, is("customer"));
        assertThat(librarenName, is("libraren"));
    }
}
