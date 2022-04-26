package hexlet.code.schemas.numberschema.defaultnumberschema;

import hexlet.code.schemas.AbstractSchema;
import hexlet.code.schemas.numberschema.NumberSchema;
import hexlet.code.schemas.util.SchemaHelper;

import java.util.function.Predicate;

public final class DefaultNumberSchema extends AbstractSchema implements NumberSchema {

    @Override
    public NumberSchema required() {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, Integer.class);
        addValidator(validator);
        return this;
    }

    @Override
    public NumberSchema positive() {
        Predicate<Object> validator = (Object o) -> {
            if (o == null) {
                return true;
            }

            return SchemaHelper.checkClassAndNull(o, Integer.class)
                    && ((Integer) o) > 0;
        };
        addValidator(validator);
        return this;
    }

    @Override
    public NumberSchema range(int min, int max) {
        Predicate<Object> validator = (Object o) -> {
            if (o == null) {
                return true;
            }

            int num = (Integer) o;
            return num >= min && num <= max;
        };
        addValidator(validator);
        return this;
    }

}
