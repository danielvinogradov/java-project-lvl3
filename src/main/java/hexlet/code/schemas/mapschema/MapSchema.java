package hexlet.code.schemas.mapschema;

import hexlet.code.schemas.BaseSchema;
//import hexlet.code.schemas.Schema;

import java.util.Map;

public interface MapSchema {

    /**
     * Требуется тип данных Map.
     *
     * @return Инстанс MapSchema.
     */
    MapSchema required();

    /**
     * Кол-во пар ключ-значений в объекте Map должно быть равно заданному.
     *
     * @param size Ожидаемое кол-во записей.
     * @return Инстанс MapSchema.
     */
    MapSchema sizeof(int size);

    /**
     * Добавить вложенную валидацию.
     * <p>
     * Например:
     * <code>
     * Map<String, BaseSchema> schemas = new HashMap<>();
     * schemas.put("name", v.string().required());
     * schemas.put("age", v.number().positive());
     * schema.shape(schemas);
     * </code>
     *
     * @param schemas Схема валидации данных.
     * @return Инстанс MapSchema.
     */
    MapSchema shape(Map<String, ? extends BaseSchema> schemas);

}
