class DynamicArray {
    int size = 0, capacity = 0;
    int[] arr = new int[0];
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size >= capacity) {
            resize();
        }

        arr[size] = n;
        size += 1;
    }

    public int popback() {
        int lastNum = arr[size - 1];
        arr[size - 1] = 0;
        size -= 1;
        return lastNum;
    }

    private void resize() {
        int[] curArr = Arrays.copyOf(arr, arr.length);
        capacity *= 2;
        arr = new int[capacity];
        for (int i = 0; i < curArr.length; i++) {
            arr[i] = curArr[i];
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
