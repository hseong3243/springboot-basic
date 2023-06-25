package com.programmers.voucher;

import com.programmers.voucher.domain.Voucher;
import com.programmers.voucher.enumtype.ConsoleCommandType;
import com.programmers.voucher.enumtype.VoucherType;
import com.programmers.voucher.io.Console;
import com.programmers.voucher.request.VoucherCreateRequest;
import com.programmers.voucher.service.VoucherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static com.programmers.voucher.testutil.VoucherTestUtil.createFixedVoucher;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ConsoleMenuTest {

    @InjectMocks
    private ConsoleMenu consoleMenu;

    @Mock
    private VoucherService voucherService;

    @Mock
    private Console console;

    @Test
    @DisplayName("create 명령 입력 - 성공")
    public void commandTypeCreate() {
        //given
        given(console.inputInitialCommand()).willReturn(ConsoleCommandType.CREATE);

        VoucherCreateRequest input = new VoucherCreateRequest(VoucherType.FIXED_AMOUNT, 10);
        given(console.inputVoucherCreateInfo()).willReturn(input);

        given(voucherService.createVoucher(any())).willReturn(UUID.randomUUID());

        //when
        //then
        consoleMenu.runClient();
    }

    @Test
    @DisplayName("list 명령 입력 - 성공")
    void commandTypeList() {
        //given
        Voucher fixedVoucher1 = createFixedVoucher(UUID.randomUUID(), 10);
        Voucher fixedVoucher2 = createFixedVoucher(UUID.randomUUID(), 10);
        List<Voucher> testVouchers = List.of(fixedVoucher1, fixedVoucher2);

        given(console.inputInitialCommand()).willReturn(ConsoleCommandType.LIST);
        given(voucherService.findVouchers()).willReturn(testVouchers);

        //when
        //then
        consoleMenu.runClient();
    }
}