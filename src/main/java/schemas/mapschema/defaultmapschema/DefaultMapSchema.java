package schemas.mapschema.defaultmapschema;

import schemas.AbstractSchema;
import schemas.mapschema.MapSchema;

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
        return this;
    }

}
