package assignment4;
//Ques4 assignment4
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueTest {

    public static void main(String[] args) {

        // PriorityQueue with custom Comparator (Lowest price first)
        PriorityQueue<Product> queue =
                new PriorityQueue<Product>(new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getProductPrice() < p2.getProductPrice())
                    return -1;
                else if (p1.getProductPrice() > p2.getProductPrice())
                    return 1;
                else
                    return 0;
            }
        });

        // Insert products
        queue.add(new Product(1, "Pen", 10.0));
        queue.add(new Product(2, "Notebook", 25.0));
        queue.add(new Product(3, "Bag", 400.0));
        queue.add(new Product(4, "Laptop", 60000.0));
        queue.add(new Product(5, "Mouse", 500.0));

        // Poll products based on priority
        while (!queue.isEmpty()) {
            Product p = queue.poll();
            System.out.println("Processing product: " + p);
        }
    }
}
