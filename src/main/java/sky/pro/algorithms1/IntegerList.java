package sky.pro.algorithms1;

import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.Random;

public class IntegerList {

    private Integer[] integerList;
    private int size;

    private static final String WRONG_DATA_ENTERED = "Некорректно введены данные";

    public IntegerList(Integer[] integerList) {
        this.integerList = integerList;
    }

    public IntegerList(int size) {
        this.integerList = new Integer[size];
    }

    public IntegerList(){
        this.integerList = new Integer[10];
    }

    public Integer add(Integer item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < integerList.length; i++) {
            if(integerList[i] == null){
                integerList[i] = item;
                return item;
            }
        }
        return null;
    }

    public Integer add(int index, Integer item){
        if(index > integerList.length -1){
            throw new ArrayIndexOutOfBoundsException("Элемент выходит за рамки массива");
        }
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = integerList.length -1; i >+ 0; i--) {
            if(i > index){
                integerList[i] = integerList[i-1];
            }
        }
        integerList[index] = item;
        return item;
    }

    public Integer set(int index, Integer item){
        if(index >= integerList.length -1){
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        integerList[index] = item;
        return null;
    }

    public Integer remove(Integer item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < integerList.length; i++) {
            if(!integerList[i].equals(item)){
                throw new IllegalArgumentException("Нет такой строки в массиве");
            }else{
                integerList[i] = null;
            }
        }
        return null;
    }

    public Integer remove(int index){
        return integerList[index] = null;
    }

    public boolean contains(Integer item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < integerList.length; i++) {
            if(integerList[i] != null && integerList[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Integer item){
        for (int i = 0; i < integerList.length; i++) {
            if(integerList[i] != null && integerList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item){
        for (int i = integerList.length -1; i >+ 0; i--) {
            if(integerList[i] != null && integerList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index){
        return integerList[index];
    }

    public boolean equals(IntegerList otherList){
        if(otherList == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < integerList.length; i++) {
            if(integerList[i] != null && otherList.get(i) != null){
                if(!integerList[i].equals(otherList.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public int size(){
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if(integerList[i] != null){
                factSize++;
            }
        }
        return factSize;
    }

    public boolean isEmpty(){
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                factSize++;
            }
        }
        return factSize == 0;
    }

    public void clear(){
        Arrays.fill(integerList,null);
    }

    public Integer[] toArray(){
        Integer[] integers = new Integer[integerList.length];
        for (int i = 0; i < integerList.length; i++) {
            integers[i] =  integerList[i];
        }
        return integers;
    }

    private void checkLength(int index){
        if(index > integerList.length){
            throw new ArrayIndexOutOfBoundsException("Элемент выходит за рамки массива");
        }
    }

    public String toString(){
        return "IntegerList" +
                "integerList" + Arrays.toString(integerList) +
                "}";
    }

    public static Integer[] toRandomArray(){
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }

    //сортировка вставкой
    private static void sortInsertion(Integer[] integers){
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while(j>0 && integers[j-1] >= temp){
                integers[j] = integers[j-1];
                j--;
            }
            integers[j] = temp;
        }
    }

    //пузырьковая сортировка
    private static void sortBubble(Integer[] integers){
        for (int i = 0; i < integers.length-1; i++) {
            for (int j = 0; i < integers.length-1-i; j++) {
                if(integers[j] > integers[j+1]){
                    swapElements(integers, j, j+1);
                }
            }
        }
    }

    //сортировка выбором
    private static void sortSelection(Integer[] integers){
        for (int i = 0; i < integers.length-1; i++) {
            int minElementIndex = i;
            for (int j = i+1; i < integers.length; j++) {
                if(integers[j] < integers[minElementIndex]){
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB){
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int binarySearch (Integer[] integers, Integer item){
        IntegerList.sortInsertion(integers);
        return Arrays.binarySearch(integers,item);
    }

    public static void main(String[] args) {
        Integer[] integers1 = IntegerList.toRandomArray();
        Integer[] integers2 = IntegerList.toRandomArray();
        Integer[] integers3 = IntegerList.toRandomArray();

        long start1 = System.currentTimeMillis();
        sortInsertion(integers1);
        System.out.println("Сортировка вставками" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        sortInsertion(integers2);
        System.out.println("Сортировка выбором" + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        sortInsertion(integers3);
        System.out.println("Сортировка пузырьком" + (System.currentTimeMillis() - start3));
    }

    private void grow(){
        integerList = Arrays.copyOf(integerList, size + size/2);
    }

    private void growIfNeeded(){
        if(size == integerList.length){
            grow();
        }
    }

    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void sort(Integer[] arr){
        quickSort(arr, 0, arr.length-1);
    }

}
