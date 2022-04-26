# [JAVA] Проект "Валидатор данных"

[![Actions Status](https://github.com/danielvinogradov/java-project-lvl3/workflows/java-ci/badge.svg)](https://github.com/danielvinogradov/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/57d87ecee4f4fcb2124e/maintainability)](https://codeclimate.com/github/danielvinogradov/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/57d87ecee4f4fcb2124e/test_coverage)](https://codeclimate.com/github/danielvinogradov/java-project-lvl3/test_coverage)

## Описание

Вариация на тему проекта Хекслета "Валидатор данных".

Небольшая библиотека для простой валидации данных. Реализует fluent interface. Есть методы для работы с `String`
, `Integer` и `Map`. Подробнее в javadoc.

Простой пример использования для `String`:

```java
class App {
    void someMethod() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.isValid(""); // true

        schema.required();

        schema.isValid("what does the fox say"); // true
        schema.isValid(""); // false

        schema.contains("what").isValid("what does the fox say"); // true
        schema.contains("whatthe").isValid("what does the fox say"); // false

        schema.isValid("what does the fox say"); // false       
    }
}
```

Также есть возможность описывать валидацию для значений `Map` по ключам с помощью `shape`:

```java
class App {
    void someMethod() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Max");
        human1.put("age", 10);
        schema.isValid(human1); // true

        Map<String, Object> human2 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        schema.isValid(human3); // false
    }
}
```

Кол-во добавляемых валидаторов не ограничено. Порядок добавления валидаторов не имеет значения.

```java
class App {
    void someMethod() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        schema
                .required()
                .shape(first_shape)
                .shape(second_shape)
                .size(3)
                .shape(third_shape);
    }
}
```

## `null`

В связи с особенностями ТЗ, валидаторы работают с `null` по-разному. В `NumberSchema` значение `null`
считается валидным (кроме проверки на `required`). Т.е. `schema.positive(null)` вернет `true`. В остальных же схемах,
значение `null` считается невалидным, т.е. `stringSchema.contains("some str").isValid(null) == false`.
