package hexlet.code.schemas.mapschema.defaultmapschema;

import hexlet.code.schemas.Schema;
import hexlet.code.schemas.mapschema.MapSchema;
import hexlet.code.schemas.numberschema.defaultnumberschema.DefaultNumberSchema;
import hexlet.code.schemas.stringschema.defaultstringschema.DefaultStringSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.TestHelper.FALSE;
import static hexlet.code.TestHelper.NEGATIVE_NUMBER;
import static hexlet.code.TestHelper.NULL;
import static hexlet.code.TestHelper.POSITIVE_NUMBER;
import static hexlet.code.TestHelper.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultMapSchemaTest {

    private static MapSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new DefaultMapSchema();
    }

    @AfterEach
    void afterEach() {
        schema = null;
    }

    @Test
    void required() {
        assertEquals(TRUE, schema.isValid(NULL));
        assertEquals(TRUE, schema.isValid(POSITIVE_NUMBER));

        schema.required();

        assertEquals(FALSE, schema.isValid(NULL));
        assertEquals(FALSE, schema.isValid(POSITIVE_NUMBER));

        final Map<String, Object> correctValue = new HashMap<>();

        assertEquals(TRUE, schema.isValid(correctValue));
    }

    @Test
    void sizeof() {
        final int size = 4;
        Map<String, Object> testedValue = new HashMap<>();

        schema.sizeof(size);
        assertEquals(FALSE, schema.isValid(testedValue));

        testedValue.put("1", null);
        testedValue.put("2", null);
        testedValue.put("3", null);
        assertEquals(FALSE, schema.isValid(testedValue));

        testedValue.put("4", null);
        assertEquals(TRUE, schema.isValid(testedValue));

        testedValue.put("5", null);
        assertEquals(FALSE, schema.isValid(testedValue));
    }

    @Test
    void shape() {
        Map<String, Schema> shape = new HashMap<>();
        final int nameMinLength = 4;
        final int correctAge = 20;
        shape.put("name", (Schema) new DefaultStringSchema().minLength(nameMinLength));
        shape.put("age", (Schema) new DefaultNumberSchema().required().positive());

        Map<String, Object> wrongTestedValue1 = new HashMap<>();
        wrongTestedValue1.put("name", "Al");
        wrongTestedValue1.put("age", NEGATIVE_NUMBER);

        Map<String, Object> wrongTestedValue2 = new HashMap<>();
        wrongTestedValue2.put("name", "Alexander");

        Map<String, Object> correctTestedValue = new HashMap<>();
        correctTestedValue.put("name", "Alexander");
        correctTestedValue.put("age", correctAge);
        correctTestedValue.put("some-other-key", POSITIVE_NUMBER);

        schema.shape(shape);

        assertEquals(FALSE, schema.isValid(wrongTestedValue1));
        assertEquals(FALSE, schema.isValid(wrongTestedValue2));
        assertEquals(TRUE, schema.isValid(correctTestedValue));
    }

    @Test
    void shapeMultipleIntersected() {
        final String shouldContainString = "java";
        final String stringThatContains = "hello java";
        final String stringThatDoesntContain = "hello c++";
        final int min = 5;
        final int max = 15;
        final int inBetween = 12;

        Map<String, Schema> shape1 = new HashMap<>();
        shape1.put("name", (Schema) new DefaultStringSchema().contains(shouldContainString));

        Map<String, Schema> shape2 = new HashMap<>();
        shape2.put("age", (Schema) new DefaultNumberSchema().required().range(min, max));

        Map<String, Object> correctValue = new HashMap<>();
        correctValue.put("name", stringThatContains);
        correctValue.put("age", inBetween);

        Map<String, Object> incorrectValue = new HashMap<>();
        incorrectValue.put("name", stringThatDoesntContain);
        incorrectValue.put("age", min - max);

        schema
                .shape(shape1)
                .shape(shape2);

        assertEquals(TRUE, schema.isValid(correctValue));
        assertEquals(FALSE, schema.isValid(incorrectValue));
    }

    @Test
    void methodsIntersectionTest() {
        Map<String, Schema> shape = new HashMap<>();
        shape.put("age", (Schema) new DefaultNumberSchema().required().positive());

        final int size = 2;
        Map<String, Object> testedValue = new HashMap<>();
        testedValue.put("1", null);
        testedValue.put("age", POSITIVE_NUMBER);

        boolean actual = schema
                .required()
                .sizeof(size)
                .shape(shape)
                .isValid(testedValue);

        assertEquals(TRUE, actual);
    }

}
