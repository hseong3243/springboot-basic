package com.programmers.voucher.global.io.textio;

import com.programmers.voucher.domain.customer.dto.CustomerDto;
import com.programmers.voucher.domain.customer.dto.request.CustomerCreateRequest;
import com.programmers.voucher.domain.customer.dto.request.CustomerUpdateRequest;
import com.programmers.voucher.domain.voucher.dto.VoucherDto;
import com.programmers.voucher.domain.voucher.dto.request.VoucherCreateRequest;
import com.programmers.voucher.global.io.Console;
import com.programmers.voucher.global.io.command.ConsoleCommandType;
import com.programmers.voucher.global.io.command.CustomerCommandType;
import com.programmers.voucher.global.io.command.VoucherCommandType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TextIoConsole implements Console {
    private final TextIoInput textIoInput;
    private final TextIoOutput textIoOutput;

    public TextIoConsole(TextIoInput textIoInput, TextIoOutput textIoOutput) {
        this.textIoInput = textIoInput;
        this.textIoOutput = textIoOutput;
    }

    @Override
    public ConsoleCommandType inputInitialCommand() {
        return textIoInput.inputInitialCommand();
    }

    @Override
    public VoucherCreateRequest inputVoucherCreateInfo() {
        return textIoInput.inputVoucherCreateInfo();
    }

    @Override
    public CustomerCreateRequest inputCustomerCreateInfo() {
        return textIoInput.inputCustomerCreateInfo();
    }

    @Override
    public CustomerUpdateRequest inputCustomerUpdateInfo() {
        return textIoInput.inputCustomerUpdateInfo();
    }

    @Override
    public UUID inputUUID() {
        return textIoInput.inputUUID();
    }

    @Override
    public VoucherCommandType inputVoucherCommandType() {
        return textIoInput.inputVoucherCommandType();
    }

    @Override
    public CustomerCommandType inputCustomerCommandType() {
        return textIoInput.inputCustomerCommandType();
    }

    @Override
    public void printCommandSet() {
        textIoOutput.printCommandSet();
    }

    @Override
    public void printCustomerCommandSet() {
        textIoOutput.printCustomerCommandSet();
    }

    @Override
    public void printVoucherCommandSet() {
        textIoOutput.printVoucherCommandSet();
    }

    @Override
    public void printVouchers(List<VoucherDto> vouchers) {
        textIoOutput.printVouchers(vouchers);
    }

    @Override
    public void printCustomers(List<CustomerDto> customers) {
        textIoOutput.printCustomers(customers);
    }

    @Override
    public void print(String result) {
        textIoOutput.print(result);
    }

    @Override
    public void printErrorMessage(RuntimeException ex) {
        textIoOutput.printErrorMessage(ex);
    }

    @Override
    public void exit() {
        textIoOutput.exit();
    }
}
