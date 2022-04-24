package schemas.stringschema.defaultstringschema;

import schemas.BaseSchema;
import schemas.stringschema.StringSchema;
import schemas.util.SchemaHelper;

import java.util.function.Predicate;

public class DefaultStringSchema extends BaseSchema implements StringSchema {

    @Override
    public StringSchema required() {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && !((String) o).isEmpty();
        addValidator(validator);
        return this;
    }

    @Override
    public StringSchema minLength(int minLength) {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && ((String) o).length() >= minLength;
        addValidator(validator);
        return this;
    }

    @Override
    public StringSchema contains(String str) {
        Predicate<Object> validator = (Object o) -> SchemaHelper.checkClassAndNull(o, String.class)
                && ((String) o).contains(str);
        addValidator(validator);

        return this;
    }

}
