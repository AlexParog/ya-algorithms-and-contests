package org.parog.java_section.fintech_30092024.exception;

import java.text.MessageFormat;
import java.util.function.Supplier;

/**
 * Класс ErrorTransferException является пользовательским исключением,
 * возникающим при ошибках в процессе перевода средств, таких как
 * некорректная сумма перевода или недостаток средств на счете.
 * Это исключение наследует {@link RuntimeException}, что позволяет
 * его не объявлять в сигнатуре методов, где оно используется.
 */
public class ErrorTransferException extends RuntimeException {

    /**
     * Создает новое исключение с указанным сообщением об ошибке.
     *
     * @param message описание причины ошибки
     */
    public ErrorTransferException(String message) {
        super(message);
    }

    /**
     * Создает новое исключение с форматированным сообщением об ошибке.
     * Используется, если необходимо добавить динамические параметры в текст ошибки.
     *
     * @param message шаблон сообщения с плейсхолдерами для параметров
     * @param args    параметры, подставляемые в шаблон сообщения
     */
    public ErrorTransferException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    /**
     * Возвращает {@link Supplier}, генерирующий новое исключение {@link ErrorTransferException}
     * с форматированным сообщением. Полезно для ленивой генерации исключений
     * в функциональном программировании, где требуется Supplier.
     *
     * @param message шаблон сообщения об ошибке
     * @param args    параметры, подставляемые в шаблон сообщения
     * @return {@link Supplier} для генерации {@link ErrorTransferException} с указанным сообщением
     */
    public static Supplier<ErrorTransferException> errorTransferException(String message, Object... args) {
        return () -> new ErrorTransferException(message, args);
    }

    /**
     * Возвращает {@link Supplier}, генерирующий новое исключение {@link ErrorTransferException}
     * с простым сообщением. Удобно использовать в случаях, когда текст ошибки статичен.
     *
     * @param message текст сообщения об ошибке
     * @return {@link Supplier} для генерации {@link ErrorTransferException} с указанным сообщением
     */
    public static Supplier<ErrorTransferException> errorTransferException(String message) {
        return () -> new ErrorTransferException(message);
    }
}

