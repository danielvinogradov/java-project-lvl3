package hexlet.code.schemas.numberschema;

public interface NumberSchemaX {

    /**
     * Проверяет валидность значения.
     *
     * @param o Проверяемое значение.
     * @return Валидно / не валидно.
     */
    boolean isValid(Object o);

    /**
     * Любое число, включая ноль.
     *
     * @return Инстанс схемы.
     */
    NumberSchemaX required();

    /**
     * Положительное число.
     *
     * @return Инстанс схемы.
     */
    NumberSchemaX positive();

    /**
     * Диапазон, в который должны попадать числа включая границы.
     *
     * @param min Минимальное значение.
     * @param max Максимальное значение.
     * @return Инстанс схемы.
     */
    NumberSchemaX range(int min, int max);

}
