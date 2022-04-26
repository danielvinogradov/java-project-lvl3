package hexlet.code.validator.defaultvalidator;

import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.mapschema.defaultmapschema.DefaultMapSchema;
import hexlet.code.schemas.numberschema.NumberSchema;
import hexlet.code.schemas.numberschema.defaultnumberschema.DefaultNumberSchema;
import hexlet.code.schemas.stringschema.StringSchema;
import hexlet.code.schemas.stringschema.defaultstringschema.DefaultStringSchema;
import hexlet.code.validator.Validator;

/**
 * Дефолтная реализация валидатора.
 */
public final class DefaultValidator implements Validator {

    @Override
    public StringSchema string() {
        return new DefaultStringSchema();
    }

    @Override
    public NumberSchema number() {
        return new DefaultNumberSchema();
    }

    @Override
    public MapSchema map() {
        return new DefaultMapSchema();
    }

}
