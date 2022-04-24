package hexlet.code.schemas.stringschema.defaultstringschema;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.stringschema.StringSchema;
import hexlet.code.schemas.util.SchemaHelper;

import java.util.function.Predicate;

public class DefaultStringSchema extends BaseSchema implements StringSchema {

    /**
     * A.
     *
     * @return A.
     */
    @Override
    public StringSchema required() {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && !((String) o).isEmpty();
        addValidator(validator);
        return this;
    }

    /**
     * A.
     *
     * @param minLength A.
     * @return A.
     */
    @Override
    public StringSchema minLength(int minLength) {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && ((String) o).length() >= minLength;
        addValidator(validator);
        return this;
    }

    /**
     * A.
     *
     * @param str A.
     * @return A.
     */
    @Override
    public StringSchema contains(String str) {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && ((String) o).contains(str);
        addValidator(validator);

        return this;
    }

}
