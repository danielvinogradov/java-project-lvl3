package hexlet.code.schemas.stringschema;

public interface StringSchema {

    boolean isValid(Object o);

    StringSchema required();

    StringSchema minLength(int minLength);

    StringSchema contains(String str);

}
