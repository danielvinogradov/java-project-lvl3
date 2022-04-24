package schemas;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Общая функциональность любой схемы.
 *
 * @param <T> Тип значения, которое валидируется.
 */
public abstract class AbstractSchema<T> {

    /**
     * Значение.
     */
    private T value;

    /**
     * Список валидаторов.
     */
    private final List<Predicate<T>> validatorsList;

    protected AbstractSchema() {
        this.validatorsList = new ArrayList<>();
    }

    /**
     * Геттер. Получить значение.
     *
     * @return Значение.
     */
    protected T getValue() {
        return value;
    }

    /**
     * Геттер. Получить список валидаторов.
     *
     * @return Список валидаторов.
     */
    protected List<Predicate<T>> getValidatorsList() {
        return validatorsList;
    }

    /**
     * Сеттер. Установить новое значение.
     *
     * @param v Новое значение.
     */
    protected void setValue(T v) {
        this.value = v;
    }

    /**
     * Добавить новый валидатор в список валидаторов. Дублирование разрешено.
     *
     * @param predicate Новый валидатор.
     */
    protected void addValidator(@NotNull Predicate<T> predicate) {
        this.validatorsList.add(predicate);
    }

}
