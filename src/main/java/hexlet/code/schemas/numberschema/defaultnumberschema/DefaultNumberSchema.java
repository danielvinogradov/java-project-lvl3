package hexlet.code.schemas.numberschema.defaultnumberschema;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.numberschema.NumberSchema;
import hexlet.code.schemas.util.SchemaHelper;

import java.util.function.Predicate;

public class DefaultNumberSchema extends BaseSchema implements NumberSchema {

    /**
     * A.
     *
     * @return A.
     */
    @Override
    public NumberSchema required() {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, Integer.class);
        addValidator(validator);
        return this;
    }

    /**
     * A.
     *
     * @return A.
     */
    @Override
    public NumberSchema positive() {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, Integer.class)
                && ((Integer) o) > 0;
        addValidator(validator);
        return this;
    }

    /**
     * A.
     *
     * @param min Минимальное значение.
     * @param max Максимальное значение.
     * @return A.
     */
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
