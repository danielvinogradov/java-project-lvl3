package schemas.numberschema.defaultnumberschema;

import schemas.AbstractSchema;
import schemas.numberschema.NumberSchema;
import schemas.util.SchemaHelper;

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
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, Integer.class)
                && ((Integer) o) > 0;
        addValidator(validator);
        return this;
    }

    @Override
    public NumberSchema range(int min, int max) {
        Predicate<Object> validator = (Object o) -> {
            boolean classNullCheckResult = SchemaHelper.checkClassAndNull(o, Integer.class);
            if (classNullCheckResult) {
                int num = (Integer) o;
                return num >= min && num <= max;
            }

            return false;
        };
        addValidator(validator);
        return this;
    }

}
