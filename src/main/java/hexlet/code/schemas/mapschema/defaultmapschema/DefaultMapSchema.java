package hexlet.code.schemas.mapschema.defaultmapschema;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.Schema;

import java.util.Map;
import java.util.function.Predicate;

public class DefaultMapSchema extends BaseSchema implements MapSchema {

    private Map<String, ?> schemasMap;

    /**
     * Ф.
     *
     * @return Ф.
     */
    @Override
    public MapSchema required() {
        Predicate<Object> validator = (Object o) -> o instanceof Map<?, ?>;
        addValidator(validator);
        return this;
    }

    /**
     * Ф.
     *
     * @param size J.
     * @return Ф.
     */
    @Override
    public MapSchema sizeof(int size) {
        Predicate<Object> validator = (Object o) -> o instanceof Map<?, ?> && ((Map<?, ?>) o).size() == size;
        addValidator(validator);
        return this;
    }

    /**
     * Ф.
     *
     * @param schemas J.
     * @return Ф.
     */
    @Override
    public MapSchema shape(Map<String, ?> schemas) {
        this.schemasMap = schemas;
        return this;
    }

    /**
     * Ф.
     *
     * @param v L.
     * @return Ф.
     */
    @Override
    public boolean isValid(Object v) {
        boolean validSchema = false;
        if (schemasMap == null) {
            validSchema = true;
        } else if (v instanceof Map<?,?>) {
            Map<String, ?> m = (Map<String, ?>) v;
            validSchema = schemasMap.keySet().stream()
                    .allMatch(key -> {
                        Schema schema = (Schema) schemasMap.get(key);
                        Object val = m.get(key);
                        return schema != null && schema.isValid(val);
                    });
        }

        return super.isValid(v) && validSchema;
    }
}
