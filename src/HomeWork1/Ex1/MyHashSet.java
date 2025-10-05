package HomeWork1.Ex1;

import java.util.LinkedList;

public class MyHashSet<E>
{
    private static final int DEFAULT_CAPACITY = 16; //Размер хэш-таблицы
    private LinkedList<E>[] MyHashTable;  //Аналог хэш-таблицы

    @SuppressWarnings("unchecked")
    public MyHashSet(){
        MyHashTable = (LinkedList<E>[]) new LinkedList[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyHashSet(int Capacity){
        MyHashTable = (LinkedList<E>[]) new LinkedList[Capacity];
    }

    // Хэш-функция (чтобы не выходить за пределы массива)
    private int getIndex(E e) {
        return (e == null) ? 0 : Math.abs(e.hashCode() % MyHashTable.length);
    }
    //Вставка
    public void add(E e){
        int index = getIndex(e);
        if (MyHashTable[index] == null) {
            MyHashTable[index] = new LinkedList<>();
        }
        if (!MyHashTable[index].contains(e)) { // проверка уникальности
            MyHashTable[index].add(e);
        }
    }
    // Удаление
    public void remove(E e){
        int index = getIndex(e);
        if (MyHashTable[index] != null) {
            MyHashTable[index].remove(e);
        }
    }
}
