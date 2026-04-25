public class Test {
    public static void main(String[] args) {

        System.out.println("=== hashx ===");
        HashTable ht = new HashTable(11);
        System.out.println("hashx(15) = " + ht.hashx(15));
        System.out.println("hashx(11) = " + ht.hashx(11));
        try {
            ht.hashx(null);
        } catch (IllegalArgumentException e) {
            System.out.println("hashx(null) exception: " + e.getMessage());
        }

        System.out.println("\n=== insert & contains ===");
        ht.insert(1);
        ht.insert(12);
        ht.insert(3);
        System.out.println("contains(1): "  + ht.contains(1));
        System.out.println("contains(12): " + ht.contains(12));
        System.out.println("contains(99): " + ht.contains(99));
        try {
            ht.insert(1);
        } catch (IllegalArgumentException e) {
            System.out.println("insert(1) duplicate exception: " + e.getMessage());
        }
        try {
            ht.contains(null);
        } catch (IllegalArgumentException e) {
            System.out.println("contains(null) exception: " + e.getMessage());
        }

        System.out.println("\n=== getValue ===");
        System.out.println("getValue(1): "  + ht.getValue(1));
        System.out.println("getValue(2): "  + ht.getValue(2));
        System.out.println("getValue(0): "  + ht.getValue(0));

        System.out.println("\n=== rehash ===");
        HashTable ht2 = new HashTable(11);
        System.out.println("Capacity before: " + ht2.getCapacity());
        ht2.insert(1);
        ht2.insert(2);
        ht2.insert(3);
        ht2.insert(4);
        ht2.insert(5);
        ht2.insert(6);
        System.out.println("Capacity after:  " + ht2.getCapacity());
        System.out.println("contains(3) after rehash: " + ht2.contains(3));

        System.out.println("\n=== printTable ===");
        ht2.printTable();
    }
}