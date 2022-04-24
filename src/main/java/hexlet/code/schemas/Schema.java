package hexlet.code.schemas;

public interface Schema {

    /**
     * Является ли значение валидным.
     *
     * @param v Проверяемое значение.
     * @return Валидно / не валидно.
     */
    boolean isValid(Object v);

}
