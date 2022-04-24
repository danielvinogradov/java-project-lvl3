package validator;

import schemas.mapschema.MapSchema;
import schemas.mapschema.defaultmapschema.DefaultMapSchema;
import schemas.numberschema.NumberSchema;
import schemas.numberschema.defaultnumberschema.DefaultNumberSchema;
import schemas.stringschema.StringSchema;
import schemas.stringschema.defaultstringschema.DefaultStringSchema;

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
