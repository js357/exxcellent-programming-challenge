package de.exxcellent.challenge.records;

/**
 * This interface defines a contract for objects that are capable of calculating a spread value.
 * Any class that implements this interface must provide an implementation of the {@link #getSpread()} method.
 */
public interface SpreadCalculable {
    /**
     * Calculates and returns the spread value for the object implementing this interface.
     *
     * <p>The method must be implemented by any class that implements this interface. The implementation
     * should compute and return the spread as a {@code double} value.</p>
     *
     * @return the calculated spread value as a {@code double}.
     */
    double getSpread();
}
