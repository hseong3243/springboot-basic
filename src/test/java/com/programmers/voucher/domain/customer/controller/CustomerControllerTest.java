package com.programmers.voucher.domain.customer.controller;

import com.programmers.voucher.domain.customer.dto.request.CustomerCreateRequest;
import com.programmers.voucher.domain.customer.dto.request.CustomerUpdateRequest;
import com.programmers.voucher.domain.customer.service.CustomerService;
import com.programmers.voucher.global.io.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private Console console;

    @Mock
    private CustomerService customerService;

    @Test
    @DisplayName("성공: Customer 생성 요청")
    void createCustomer() {
        //given
        CustomerCreateRequest request = new CustomerCreateRequest("customer@gmail.com", "customer");
        UUID customerId = UUID.randomUUID();

        given(console.inputCustomerCreateInfo()).willReturn(request);
        given(customerService.createCustomer(any(), any())).willReturn(customerId);

        //when
        customerController.createCustomer();

        //then
        then(console).should().print(anyString());
    }

    @Test
    @DisplayName("성공: Customer 업데이트 요청")
    void updateCustomer() {
        //given
        CustomerUpdateRequest request = new CustomerUpdateRequest(UUID.randomUUID(), "updatedName");
        given(console.inputCustomerUpdateInfo()).willReturn(request);

        //when
        customerController.updateCustomer();

        //then
        then(customerService).should().updateCustomer(any(), any());
        then(console).should().print(anyString());
    }

}