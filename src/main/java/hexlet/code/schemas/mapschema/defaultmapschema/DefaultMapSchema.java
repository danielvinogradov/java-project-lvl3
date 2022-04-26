package hexlet.code.schemas.mapschema.defaultmapschema;

import hexlet.code.schemas.AbstractSchema;
import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.Schema;

import java.util.Map;
import java.util.function.Predicate;

public final class DefaultMapSchema extends AbstractSchema implements MapSchema {

    private Map<String, Schema> schemasMap;

    @Override
    public MapSchema required() {
        Predicate<Object> validator = (Object o) -> o instanceof Map<?, ?>;
        addValidator(validator);
        return this;
    }

    @Override
    public MapSchema sizeof(int size) {
        Predicate<Object> validator = (Object o) -> o instanceof Map<?, ?> && ((Map<?, ?>) o).size() == size;
        addValidator(validator);
        return this;
    }

    @Override
    public MapSchema shape(Map<String, Schema> schemas) {
        this.schemasMap = schemas;
        return this;
    }

    @Override
    public boolean isValid(Object v) {
        boolean validSchema = false;
        if (schemasMap == null) {
            validSchema = true;
        } else if (v instanceof Map<?, ?>) {
            Map<String, ?> m = (Map<String, ?>) v;
            validSchema = schemasMap.keySet().stream()
                    .allMatch(key -> {
                        Schema schema = schemasMap.get(key);
                        Object val = m.get(key);
                        return schema != null && schema.isValid(val);
                    });
        }

        return super.isValid(v) && validSchema;
    }
}
