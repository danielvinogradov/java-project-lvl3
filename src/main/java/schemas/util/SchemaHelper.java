package schemas.util;

public final class SchemaHelper {

    private SchemaHelper() {
    }

    public static boolean checkClassAndNull(Object a, Class<?> clazz) {
        return a != null && a.getClass() == clazz;
    }

}
