package hexlet.code.schemas.numberschema.defaultnumberschema;

import hexlet.code.schemas.numberschema.NumberSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hexlet.code.TestHelper.TRUE;
import static hexlet.code.TestHelper.FALSE;
import static hexlet.code.TestHelper.NULL;
import static hexlet.code.TestHelper.POSITIVE_NUMBER;
import static hexlet.code.TestHelper.NEGATIVE_NUMBER;
import static hexlet.code.TestHelper.ZERO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultNumberSchemaTest {

    private static NumberSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new DefaultNumberSchema();
    }

    @AfterEach
    void afterEach() {
        schema = null;
    }

    @Test
    void required() {
        assertEquals(TRUE, schema.isValid(NULL));

        schema.required();

        assertEquals(FALSE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));
    }

    @Test
    void positive() {
        schema.positive();

        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));
        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(FALSE, schema.isValid(ZERO));
        assertEquals(FALSE, schema.isValid(NEGATIVE_NUMBER));
    }

    @Test
    void range() {
        final int min = 10;
        final int max = 15;
        final int inBetween = 12;
        final int notInBetweenMore = 17;
        final int notInBetweenLess = 4;

        schema.range(min, max);

        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(min));
        assertEquals(TRUE, schema.isValid(max));
        assertEquals(TRUE, schema.isValid(inBetween));

        assertEquals(FALSE, schema.isValid(notInBetweenLess));
        assertEquals(FALSE, schema.isValid(notInBetweenMore));
    }

    /**
     * Проверяем, что все методы можно вызывать последовательно.
     */
    @Test
    void methodChainingTest() {
        final int min = 100;
        final int max = 120;
        final int inBetween = 105;
        final boolean actual = schema
                .required()
                .positive()
                .range(min, max)
                .isValid(inBetween);

        assertEquals(TRUE, actual);
    }

}
