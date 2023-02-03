package co.edu.uniquindio.ingesis;

public interface Shape extends Comparable<Shape>{
    float computeArea();

    /**
     * Define a default method in an interface
     *
     * @param other the object to be compared.
     * @return the value 0 if the argument string is equal to this string; a value less than 0 if this string is
     * lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically
     * greater than the string argument.
     */
    @Override
    default int compareTo(Shape other) {
        return (int) (computeArea() - other.computeArea());
    }
}
