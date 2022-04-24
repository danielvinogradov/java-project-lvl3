package hexlet.code.validator;

import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.mapschema.defaultmapschema.DefaultMapSchema;
import hexlet.code.schemas.numberschema.NumberSchema;
import hexlet.code.schemas.numberschema.defaultnumberschema.DefaultNumberSchema;
import hexlet.code.schemas.stringschema.StringSchema;
import hexlet.code.schemas.stringschema.defaultstringschema.DefaultStringSchema;

public class Validator {

    /**
     * A.
     *
     * @return A.
     */
    public StringSchema string() {
        return new DefaultStringSchema();
    }

    /**
     * A.
     *
     * @return A.
     */
    public NumberSchema number() {
        return new DefaultNumberSchema();
    }

    /**
     * A.
     *
     * @return A.
     */
    public MapSchema map() {
        return new DefaultMapSchema();
    }

}
