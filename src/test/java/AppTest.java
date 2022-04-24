import hexlet.code.schemas.stringschema.StringSchema;
import hexlet.code.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        boolean expected = true;
        boolean actual = schema.isValid(""); // true
        assertEquals(expected, actual);

        expected = true;
        actual = schema.isValid(null); // true
        assertEquals(expected, actual);

        schema.required();

        expected = true;
        actual = schema.isValid("what does the fox say"); // true
        assertEquals(expected, actual);

        expected = true;
        actual = schema.isValid("hexlet"); // true
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid(null); // false
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid(""); // false
        assertEquals(expected, actual);

        expected = true;
        actual = schema.contains("what").isValid("what does the fox say"); // true
        assertEquals(expected, actual);

        expected = false;
        actual = schema.contains("whatthe").isValid("what does the fox say"); // false
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid("what does the fox say"); // false
        // уже false, так как добавлена ещё одна проверка contains("whatthe")
        assertEquals(expected, actual);

    }

//    @Test
//    void test2() {
//        Validator v = new Validator();
//
//        MapSchema schema = v.map();
//
//// shape - позволяет описывать валидацию для значений объекта Map по ключам.
//        Map<String, BaseSchema> schemas = new HashMap<>();
//        schemas.put("name", v.string().required());
//        schemas.put("age", v.number().positive());
//        schema.shape(schemas);
//
//        Map<String, Object> human1 = new HashMap<>();
//        human1.put("name", "Kolya");
//        human1.put("age", 100);
//        // true
//        assertEquals(true, schema.isValid(human1));
//
//        Map<String, Object> human2 = new HashMap<>();
//        human2.put("name", "Maya");
//        human2.put("age", null); // true
////        ;
//        assertEquals(true, schema.isValid(human2));
//
//        Map<String, Object> human3 = new HashMap<>();
//        human3.put("name", "");
//        human3.put("age", null);
//        schema.isValid(human3); // false
//        assertEquals(false, schema.isValid(human3));
//
//        Map<String, Object> human4 = new HashMap<>();
//        human4.put("name", "Valya");
//        human4.put("age", -5);
//        schema.isValid(human4); // false
//        assertEquals(false, schema.isValid(human4));
//    }

}
