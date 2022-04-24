package hexlet.code.schemas;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Общая функциональность любой схемы.
 */
public abstract class BaseSchema implements Schema {

    /**
     * Список валидаторов.
     */
    private final List<Predicate<Object>> validatorsList;

    protected BaseSchema() {
        this.validatorsList = new ArrayList<>();
    }

    /**
     * Геттер. Получить список валидаторов.
     *
     * @return Список валидаторов.
     */
    protected List<Predicate<Object>> getValidatorsList() {
        return validatorsList;
    }

    /**
     * Добавить новый валидатор в список валидаторов. Дублирование разрешено.
     *
     * @param predicate Новый валидатор.
     */
    protected void addValidator(@NotNull Predicate<Object> predicate) {
        this.validatorsList.add(predicate);
    }

    /**
     * Проверяет валидность переданного значения, применяя к нему все
     * добавленные валидаторы.
     *
     * @param v Проверяемое значение.
     * @return Значение валидно / не валидно.
     */
    @Override
    public boolean isValid(Object v) {
        return getValidatorsList().stream()
                .allMatch(el -> el.test(v));
    }

}
