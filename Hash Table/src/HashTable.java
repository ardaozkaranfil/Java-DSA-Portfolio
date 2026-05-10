public class HashTable
{
    private int capacity;
    private int elementSize;
    private Integer[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.elementSize = 0;
        this.table = new Integer[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getElementSize() {
        return elementSize;
    }

    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }

    public Integer[] getTable() {
        return table;
    }

    public void setTable(Integer[] table) {
        this.table = table;
    }

    public void printTable()
    {
        for (int ind = 0; ind < getCapacity(); ind++)
        {
            if (getTable()[ind] != null) {
                System.out.println(ind + ": |" + getTable()[ind] + "|");
            }
            else
            {
                System.out.println(ind + ": |  |");
            }
        }
    }

    private boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    private int nextPrime(int N)
    {
        if (N <= 1)
            return 2;

        int prime = N*2;
        boolean found = false;

        while (!found)
        {
            prime++;

            if (isPrime(prime))
                found = true;
        }

        return prime;
    }

    /**
     * Returns the hash index for the given value.
     * @time O(1)
     */
    protected Integer hashx(Integer x) {
        if(x == null){
            throw new IllegalArgumentException("x must be integer!");
        }
        return Math.floorMod(x, capacity);
    }

    /**
     * Expands the table and reinserts all elements.
     * @time O(n)
     */
    protected void rehash() {
        if((double) (elementSize + 1) / capacity >= 0.5) {
            capacity = nextPrime(capacity);

            Integer[] temp = table;
            table = new Integer[capacity];
            elementSize = 0;

            for(int i = 0; i < temp.length; i++){
                if(temp[i] == null){
                    continue;
                }
                else{
                    insert(temp[i]);
                }
            }
        }
        else{
            System.out.println("\uF06C < 0.5 because of that rehash is unnecessary.");
        }
    }

    /**
     * Inserts the given value using quadratic probing.
     * @time O(1) average
     */
    public void insert(Integer x) {
        if(x == null){
            throw new IllegalArgumentException("x must be integer!");
        }
        else if(contains(x)){
            throw new IllegalArgumentException("Table already contains " + x + ".");
        }
        else if((double)(elementSize + 1) / capacity >= 0.5){
            rehash();
            insert(x);
        }
        else{
            int temp = hashx(x);
            int i = 1;
            boolean placed = false;

            while(!placed){
                if(table[temp] == null){
                    table[temp] = x;
                    elementSize++;
                    placed = true;
                }
                else {
                    temp = (hashx(x) + i * i) % capacity;
                    i++;
                }
            }
        }
    }

    /**
     * Checks whether the table contains the given value.
     * @time O(1) average
     */
    public Boolean contains(Integer value)
    {
        if(value == null){
            throw new IllegalArgumentException("value must be integer!");
        }
        int idx = hashx(value);
        int i = 1;
        while (table[idx] != null) {
            if (value.equals(table[idx])) return true;
            idx = (hashx(value) + i * i) % capacity;
            i++;
            if (i > capacity) break;
        }
        return false;
    }

    /**
     * Returns the value at the given index, or -1 if empty.
     * @time O(1)
     */
    public Integer getValue(int key) {
        if(table[key] == null){
            return -1;
        }
        else{
            return table[key];
        }
    }
}