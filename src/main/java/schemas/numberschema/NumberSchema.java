package schemas.numberschema;

public interface NumberSchema {

    boolean isValid(Object o);

    /**
     * Любое число, включая ноль.
     */
    NumberSchema required();

    /**
     * Положительное число.
     */
    NumberSchema positive();

    /**
     * Диапазон, в который должны попадать числа включая границы
     */
    NumberSchema range(int min, int max);

}
