package hexlet.code.schemas.numberschema;

import hexlet.code.schemas.Schema;

public interface NumberSchema extends Schema {

    @Override
    boolean isValid(Object o);

    /**
     * Любое число, включая ноль.
     *
     * @return Инстанс схемы.
     */
    NumberSchema required();

    /**
     * Положительное число.
     *
     * @return Инстанс схемы.
     */
    NumberSchema positive();

    /**
     * Диапазон, в который должны попадать числа включая границы.
     *
     * @param min Минимальное значение.
     * @param max Максимальное значение.
     * @return Инстанс схемы.
     */
    NumberSchema range(int min, int max);

}
