package com.programmers.voucher.domain.voucher.domain;

import com.programmers.voucher.domain.voucher.pattern.VoucherVisitor;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Voucher {
    protected final UUID voucherId;
    protected UUID customerId;
    protected final LocalDateTime createdAt;

    public Voucher(UUID voucherId) {
        this.voucherId = voucherId;
        this.createdAt = LocalDateTime.now();
    }

    public Voucher(UUID voucherId, LocalDateTime createdAt) {
        this.voucherId = voucherId;
        this.createdAt = createdAt;
    }

    public void assignCustomer(UUID customerId) {
        this.customerId = customerId;
    }

    public abstract void accept(VoucherVisitor visitor);

    public abstract long totalAmount(long beforeAmount);

    public UUID getVoucherId() {
        return voucherId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
