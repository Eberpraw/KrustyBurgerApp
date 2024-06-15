package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Items> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Items items) {
        items.add(items);
    }

    public List<Items> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Items::getPrice).sum();
    }
}
