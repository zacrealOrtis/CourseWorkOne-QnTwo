

package isaacwandyakaortis.q2main;

public class Q2Main {

    public static void printAreas(Shape[] shapes) {

        System.out.println("Areas of Shapes:");

        for (Shape s : shapes) {
            System.out.printf("%s -> %.2f%n",
                    s.getClass().getSimpleName(),
                    s.getArea());
        }
    }

    public static Shape largest(Shape[] shapes) {

        Shape max = shapes[0];

        for (int i = 1; i < shapes.length; i++) {

            if (shapes[i].getArea() > max.getArea()) {
                max = shapes[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        try {

            Shape[] shapes = {

                new Circle(5, "Red", true),
                new Rectangle(4, 6, "Blue", false),
                new Triangle(3, 4, 5,
                             "Green", true)
            };

            printAreas(shapes);

            Shape biggest = largest(shapes);

            System.out.println(
                    "\nLargest Shape: " + biggest);

            // Demonstrate resize
            shapes[0].resize(2);

            System.out.println(
                    "\nCircle after resize:");
            System.out.println(shapes[0]);

        }

        catch (InvalidShapeException e) {
            System.out.println(
                    "Error: " + e.getMessage());
        }

        // Demonstrate exception handling
        try {

            Triangle t =
                new Triangle(1, 2, 10,
                             "Black", true);

        }

        catch (InvalidShapeException e) {

            System.out.println(
                "\nCaught Exception:");
            System.out.println(e.getMessage());
        }
    }
}
