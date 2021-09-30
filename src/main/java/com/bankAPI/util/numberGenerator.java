package com.bankAPI.util;

/**
 * Утильный класс для генерации номера бакновского счёта и номера карты.
 */
//TODO: учёт сгенерированных номеров для исключения коллизий
public class numberGenerator {
    private static final int START_INTERVAL = 1000;
    private static final int endIntervalDefault = 9999;
    private static int endInterval = endIntervalDefault;
    private static final int accountGenerateIterations = 5;
    private static final int cardGenerateIterations = 4;

    private numberGenerator() {
    }

    public static final String generateAccountNumber() {
        return generateSequence(accountGenerateIterations);
    }

    public static final String generateCardNumber() {
        return generateSequence(cardGenerateIterations);
    }
//TODO: генерить по 1 цифре, не по 4, чтобы не зависеть от кратности 4м
    private static final int generateNumber() {
        endInterval = endIntervalDefault;
        endInterval -= START_INTERVAL;
        return (int) ((Math.random() * endInterval) + START_INTERVAL);
    }

    private static final String generateSequence(int iterations) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < iterations; i++) {
            sb.append(generateNumber());
        }
        return new String(sb);
    }
}
