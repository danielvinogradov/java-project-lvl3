package schemas.stringschema.defaultstringschema;

import schemas.AbstractSchema;
import schemas.stringschema.StringSchema;

import java.util.function.Predicate;

public final class DefaultStringSchema extends AbstractSchema<String> implements StringSchema {

    @Override
    public boolean isValid(String s) {
        setValue(s);
        return getValidatorsList().stream()
                .allMatch(el -> el.test(s));
    }

    @Override
    public StringSchema required() {
        Predicate<String> predicate = (String v) -> {
            if (v == null) {
                return false;
            }

            return !v.isEmpty();
        };

        addValidator(predicate);

        return this;
    }

    @Override
    public StringSchema minLength(int minLength) {
        Predicate<String> predicate = (String v) -> {
            if (v == null) {
                return false;
            }

            return v.length() >= minLength;
        };

        addValidator(predicate);

        return this;
    }

    @Override
    public StringSchema contains(String str) {
        Predicate<String> predicate = (String v) -> {
            if (v == null) {
                return false;
            }

            return v.contains(str);
        };

        addValidator(predicate);

        return this;
    }

}
