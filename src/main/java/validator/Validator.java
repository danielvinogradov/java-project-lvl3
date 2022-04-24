package validator;

import schemas.numberschema.NumberSchema;
import schemas.numberschema.defaultnumberschema.DefaultNumberSchema;
import schemas.stringschema.StringSchema;
import schemas.stringschema.defaultstringschema.DefaultStringSchema;

public final class Validator {

    public StringSchema string() {
        return new DefaultStringSchema();
    }

    public NumberSchema number() {
        return new DefaultNumberSchema();
    }

}
