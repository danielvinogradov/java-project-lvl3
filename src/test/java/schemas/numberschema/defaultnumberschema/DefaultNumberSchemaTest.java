package schemas.numberschema.defaultnumberschema;

import org.junit.jupiter.api.Test;
import schemas.numberschema.NumberSchema;
import schemas.util.SchemaHelper;
import validator.Validator;

import static org.junit.jupiter.api.Assertions.*;

class DefaultNumberSchemaTest {

    @Test
    void test() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        boolean expected = true;
        boolean actual = schema.isValid(null); // true
        assertEquals(expected, actual);

        schema.required();

        expected = false;
        actual = schema.isValid(null); // false
        assertEquals(expected, actual);

        expected = true;
        actual = schema.isValid(10); // true
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid("5"); // false
        assertEquals(expected, actual);

        expected = true;
        actual = schema.positive().isValid(10); // true
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid(-10); // false
        assertEquals(expected, actual);

        schema.range(5, 10);

        expected = true;
        actual = schema.isValid(5); // true
        assertEquals(expected, actual);

        expected = true;
        actual = schema.isValid(10); // true
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid(4); // false
        assertEquals(expected, actual);

        expected = false;
        actual = schema.isValid(11); // false
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        boolean expected = true;
        boolean actual = SchemaHelper.checkClassAndNull(10, Integer.class);
        assertEquals(expected, actual);

        boolean expected2 = false;
        boolean actual2 = SchemaHelper.checkClassAndNull(10, String.class);
        assertEquals(expected2, actual2);
    }

}
