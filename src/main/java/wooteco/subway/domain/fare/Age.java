package wooteco.subway.domain.fare;

import java.util.Objects;
import wooteco.subway.exception.NegativeAgeException;

public class Age {

    private final int value;

    public Age(int value) {
        validatePositiveAge(value);
        this.value = value;
    }

    private void validatePositiveAge(int value) {
        if (value < 0) {
            throw new NegativeAgeException();
        }
    }

    public boolean isGreaterThanOrEqualTo(int age) {
        return value >= age;
    }

    public boolean isLessThanOrEqualTo(int age) {
        return value <= age;
    }

    public boolean isBetween(int smallAge, int bigAge) {
        return smallAge <= value && value <= bigAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Age age = (Age) o;
        return value == age.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Age{" +
                "value=" + value +
                '}';
    }
}
