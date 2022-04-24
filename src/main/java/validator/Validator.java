package validator;

import schemas.stringschema.StringSchema;
import schemas.stringschema.defaultstringschema.DefaultStringSchema;

public final class Validator {

    public StringSchema string() {
        return new DefaultStringSchema();
    }

}
