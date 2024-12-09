package org.parog.java_section.bank_09122024.exception;

import org.parog.java_section.fintech_30092024.exception.ErrorTransferException;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class NotValidAmountException extends RuntimeException {
    /**
     * Создает новое исключение с указанным сообщением об ошибке.
     *
     * @param message описание причины ошибки
     */
    public NotValidAmountException(String message) {
        super(message);
    }

    /**
     * Создает новое исключение с форматированным сообщением об ошибке.
     * Используется, если необходимо добавить динамические параметры в текст ошибки.
     *
     * @param message шаблон сообщения с плейсхолдерами для параметров
     * @param args    параметры, подставляемые в шаблон сообщения
     */
    public NotValidAmountException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    /**
     * Возвращает {@link Supplier}, генерирующий новое исключение {@link NotValidAmountException}
     * с форматированным сообщением. Полезно для ленивой генерации исключений
     * в функциональном программировании, где требуется Supplier.
     *
     * @param message шаблон сообщения об ошибке
     * @param args    параметры, подставляемые в шаблон сообщения
     * @return {@link Supplier} для генерации {@link ErrorTransferException} с указанным сообщением
     */
    public static Supplier<NotValidAmountException> notValidAmountException(String message, Object... args) {
        return () -> new NotValidAmountException(message, args);
    }

    /**
     * Возвращает {@link Supplier}, генерирующий новое исключение {@link NotValidAmountException}
     * с простым сообщением. Удобно использовать в случаях, когда текст ошибки статичен.
     *
     * @param message текст сообщения об ошибке
     * @return {@link Supplier} для генерации {@link NotValidAmountException} с указанным сообщением
     */
    public static Supplier<NotValidAmountException> notValidAmountException(String message) {
        return () -> new NotValidAmountException(message);
    }
}
