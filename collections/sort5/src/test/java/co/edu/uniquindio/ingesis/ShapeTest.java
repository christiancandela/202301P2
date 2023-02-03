package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ShapeTest {

    @Test
    void sort() {
        List<Shape> list = new ArrayList<>();

        list.add(new Circle(3f));
        list.add(new Square(3f));
        list.add(new Triangle(3f, 2f));

        for (Shape shape : list) {
            System.out.println(shape.computeArea());
        }

        System.out.println("ordering...");

        // this line sort the list
        list.sort( Comparator.comparingDouble(Shape::computeArea) );

        // this line generate a list sorted without affect to the original list
        List<Shape> listaOrdenada = list.stream()
                .sorted( Comparator.comparingDouble(Shape::computeArea) )
                .collect(Collectors.toList());

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

        System.out.println("reordering...");

        list.sort( Comparator.comparingDouble(Shape::computeArea).reversed() );

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

    }
}