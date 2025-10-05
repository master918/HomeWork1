package HomeWork1.Ex1;
import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private Object[] data; // внутренний массив (выделенная память)
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;   // количество элементов

    //Конструкторы
    public MyArrayList(){ //Если не задавать емкость (по умолчанию 10)
        data = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int Capacity){ //С указанием емкости
        ensureCapacity(Capacity);
    }

    // увеличение емкости списка
    private void ensureCapacity(int NewSize) {
        if (data == null){data = new Object[NewSize];return;}
        data = Arrays.copyOf(data, NewSize);
    }


    // добавить элемент в конец
    public void add(E e) {
        if (size >= data.length){ensureCapacity(size+1);}
        data[size++] = e;
    }

    // добавить элемент с указанием индекса
    public void add(int index, E e) {
        checkIndexForAdd(index);
        if (size >= data.length){ensureCapacity(size+1);}

        // сдвигаем элементы вправо
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // вставляем новый элемент
        data[index] = e;
        size++;
    }

    // проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // получить элемент по индексу
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    // удалить по индексу
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null; // освобождаем последний элемент
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    // добавить все элементы из другого списка
    public void addAll(int index, Collection<? extends E> col) {
        if (!(col == null || col.isEmpty())){
            checkIndexForAdd(index); // проверка индекса для вставки (0 <= index <= size)

            int newSize = size + col.size();
            ensureCapacity(newSize); // увеличить массив, если нужно

            // сдвигаем существующие элементы вправо
            for (int i = size - 1; i >= index; i--) {
                data[i + col.size()] = data[i];
            }

            // вставляем элементы коллекции
            int j = index;
            for (E e : col) {
                data[j++] = e;
            }

            size = newSize;
        }
    }
}
