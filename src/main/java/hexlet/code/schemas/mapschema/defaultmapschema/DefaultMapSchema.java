package hexlet.code.schemas.mapschema.defaultmapschema;

import hexlet.code.schemas.AbstractSchema;
import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.Schema;

import java.util.Map;
import java.util.function.Predicate;

public final class DefaultMapSchema extends AbstractSchema implements MapSchema {

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
        Predicate<Object> validator = (Object o) -> {
            if (o == null) {
                return true;
            }

            if (!(o instanceof Map<?, ?>)) {
                return false;
            }

            return schemas.keySet().stream()
                    .allMatch(key -> {
                        Schema schema = schemas.get(key);
                        Object checkedValue = ((Map<?, ?>) o).get(key);
                        return schema.isValid(checkedValue);
                    });
        };
        addValidator(validator);
        return this;
    }

}
