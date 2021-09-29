package com.bankAPI.serializer;

import com.bankAPI.model.BankAccount;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Интерфейс, объявляющий методы для сериализации/десериализации
 */
public interface StreamSerializer {
    void writeTo(BankAccount account, OutputStream outputStream) throws IOException;
    BankAccount readBankAccount(InputStream inputStream) throws IOException;
}
