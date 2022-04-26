package hexlet.code.schemas.stringschema;

import hexlet.code.schemas.Schema;
import org.jetbrains.annotations.NotNull;

public interface StringSchema extends Schema {

    @Override
    boolean isValid(Object o);

    /**
     * Проверяет, что строка не пустая, и не равна null.
     *
     * @return Валидно / не валидно.
     */
    StringSchema required();

    /**
     * Проверяет, что значение имеет длину не меньшую, чем minLength.
     *
     * @param minLength Минимальная длина.
     * @return Валидно / не валидно.
     */
    StringSchema minLength(int minLength);

    /**
     * Содержит ли значение переданную подстроку.
     *
     * @param str Подстрока, наличие которой проверяется.
     * @return Валидно / не валидно.
     */
    StringSchema contains(@NotNull String str);

}
