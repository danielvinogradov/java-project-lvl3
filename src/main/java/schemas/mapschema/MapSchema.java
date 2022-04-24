package schemas.mapschema;

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

}
