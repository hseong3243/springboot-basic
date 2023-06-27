package com.programmers.voucher.global.io;

import com.programmers.voucher.domain.voucher.dto.request.VoucherCreateRequest;

public interface Console {
    ConsoleCommandType inputInitialCommand();

    void printCommandSet();

    VoucherCreateRequest inputVoucherCreateInfo();

    void print(String result);

    void exit();
}
