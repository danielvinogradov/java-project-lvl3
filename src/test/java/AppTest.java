import org.junit.jupiter.api.Test;
import schemas.stringschema.StringSchema;
import validator.Validator;

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

}
