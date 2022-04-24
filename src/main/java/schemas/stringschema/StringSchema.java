package schemas.stringschema;

public interface StringSchema {

    boolean isValid(String s);

    StringSchema required();

    StringSchema minLength(int minLength);

    StringSchema contains(String str);

}
