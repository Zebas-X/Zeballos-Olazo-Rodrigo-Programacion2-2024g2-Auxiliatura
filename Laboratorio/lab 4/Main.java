public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Electronic("Laptop", 1000.0));
        store.addProduct(new Electronic("Smartphone", 500.0));
        store.addProduct(new Accessory("Headphones", 150.0));
        store.addProduct(new Accessory("Charger", 30.0));

        Discountable tenPercentDiscount = product -> product.getPrice() * 0.9;
        store.applyDiscount(tenPercentDiscount);

        Discountable fiftyDollarsDiscount = product -> product.getPrice() - 50.0;
        store.applyDiscount(fiftyDollarsDiscount);

        Discountable fifteenPercentDiscount = product -> product.getPrice() * 0.85;
        store.applyDiscount(fifteenPercentDiscount);

        Discountable combinedDiscount = product -> (product.getPrice() * 0.9) - 50.0;
        store.applyDiscount(combinedDiscount);
    }
}
