package de.exxcellent.challenge.records;

/**
 * This is an abstract base class for records that implements the {@link SpreadCalculable} interface.
 * It provides a template for subclasses that need to calculate a spread value.
 * The {@link #getSpread()} method must be implemented by subclasses to return the spread value.
 *
 * <p>Note: This class cannot be instantiated directly, as it is abstract.</p>
 */
public abstract class BaseRecord implements SpreadCalculable {

    @Override
    public abstract double getSpread();

}
