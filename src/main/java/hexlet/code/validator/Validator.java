package hexlet.code.validator;

import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.numberschema.NumberSchema;
import hexlet.code.schemas.stringschema.StringSchema;

public interface Validator {

    /**
     * Создает и возвращает инстанс одной из реализаций StringSchema.
     *
     * @return Инстанс схемы для валидации строк (String).
     */
    StringSchema string();

    /**
     *  Создает и возвращает инстанс одной из реализаций NumberSchema.
     *
     * @return Инстанс схемы для валидации чисел (Integer).
     */
    NumberSchema number();

    /**
     * Создает и возвращает инстанс одной из реализаций MapSchema.
     *
     * @return Инстанс схемы для валидации Map.
     */
    MapSchema map();

}
