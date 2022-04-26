package hexlet.code.schemas.stringschema.defaultstringschema;

import hexlet.code.schemas.stringschema.StringSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hexlet.code.TestHelper.EMPTY_STRING;
import static hexlet.code.TestHelper.FALSE;
import static hexlet.code.TestHelper.NULL;
import static hexlet.code.TestHelper.POSITIVE_NUMBER;
import static hexlet.code.TestHelper.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultStringSchemaTest {

    private static StringSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new DefaultStringSchema();
    }

    @AfterEach
    void afterEach() {
        schema = null;
    }

    @Test
    void required() {
        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));
        assertEquals(TRUE, schema.isValid(EMPTY_STRING));

        schema.required();

        assertEquals(FALSE, schema.isValid(NULL));
        assertEquals(FALSE, schema.isValid(POSITIVE_NUMBER));
        assertEquals(FALSE, schema.isValid(EMPTY_STRING));

        final String shortText = "some string!";
        assertEquals(TRUE, schema.isValid(shortText));
    }

    @Test
    void minLength() {
        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));

        final int minLength = 10;
        final String shorterString = "abc";
        final String exactLengthString = "1234567890";
        final String longerString = shorterString + exactLengthString;

        schema.minLength(minLength);

        assertEquals(FALSE, schema.isValid(NULL));
        assertEquals(FALSE, schema.isValid(POSITIVE_NUMBER));

        assertEquals(FALSE, schema.isValid(shorterString));
        assertEquals(TRUE, schema.isValid(exactLengthString));
        assertEquals(TRUE, schema.isValid(longerString));
    }

    @Test
    void contains() {
        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));

        final String shouldContainString = "hello";

        final String stringThatContains1 = "wow!hello";
        final String stringThatContains2 = "hello00w";
        final String stringThatContains3 = "dkfjehellol38";

        final String stringThatDoesntContain1 = "adjfklslkbck";
        final String stringThatDoesntContain2 = "helqlo";

        schema.contains(shouldContainString);

        assertEquals(TRUE, schema.isValid(stringThatContains1));
        assertEquals(TRUE, schema.isValid(stringThatContains2));
        assertEquals(TRUE, schema.isValid(stringThatContains3));

        assertEquals(FALSE, schema.isValid(stringThatDoesntContain1));
        assertEquals(FALSE, schema.isValid(stringThatDoesntContain2));
    }

    /**
     * Проверяет, что корректно работает с множественными `.contains`.
     */
    @Test
    void containsMultiple() {
        final String shouldContainString1 = "hello";
        final String shouldContainString2 = "java";

        final String stringThatContains1 = "hello java";
        final String stringThatContains2 = "some textjava some else 8hello";

        final String stringThatContainsSome1 = "hello well jav";
        final String stringThatContainsSome2 = "java is nice";

        schema
                .contains(shouldContainString1)
                .contains(shouldContainString2);

        assertEquals(TRUE, schema.isValid(stringThatContains1));
        assertEquals(TRUE, schema.isValid(stringThatContains2));

        assertEquals(FALSE, schema.isValid(stringThatContainsSome1));
        assertEquals(FALSE, schema.isValid(stringThatContainsSome2));
    }

    /**
     * Проверяет, что корректно работает method chaining.
     */
    @Test
    void methodChainingTest() {
        final String testedValue = "hello java";
        final String shouldContainString = "hello";
        final int minLength = 5;
        final boolean actual = schema
                .required()
                .minLength(minLength)
                .contains(shouldContainString)
                .isValid(testedValue);

        assertEquals(TRUE, actual);
    }

}
