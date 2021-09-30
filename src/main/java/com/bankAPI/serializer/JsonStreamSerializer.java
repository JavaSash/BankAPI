package com.bankAPI.serializer;

import com.bankAPI.dto.ArrayOfCardsDto;
import com.bankAPI.dto.CardDto;
import com.bankAPI.model.BankAccount;
import com.bankAPI.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс для сериализации/десериализации объектов в JSON.
 */

public class JsonStreamSerializer implements StreamSerializer {

    @Override
    public void writeTo(BankAccount account, OutputStream outputStream) throws IOException {
        try (Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            JsonParser.write(account, writer);
        }
    }

    @Override
    public BankAccount readBankAccount(InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, BankAccount.class);
        }
    }

    public CardDto readArrayCardsDto(InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, CardDto.class);
        }
    }

}
