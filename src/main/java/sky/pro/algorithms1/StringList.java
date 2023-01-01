package sky.pro.algorithms1;

import java.util.Arrays;
import java.util.Objects;

public class StringList {
    private final String[] stringList;

    private final int size;

    private static final String WRONG_DATA_ENTERED = "Некорректно введены данные";

    public StringList(int size) {
        this.size = size;
        this.stringList = new String[size];
    }

    public String add(String item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if(stringList[i] == null){
                stringList[i] = item;
                return item;
            }
        }
        return null;
    }

    public String add(int index, String item){
        if(index > stringList.length -1){
            throw new ArrayIndexOutOfBoundsException("Элемент выходит за рамки массива");
        }
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = stringList.length -1; i >+ 0; i--) {
            if(i > index){
                stringList[i] = stringList[i-1];
            }
        }
        stringList[index] = item;
        return item;
    }

    public String set(int index, String item){
        if(index >= stringList.length -1){
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        stringList[index] = item;
        return null;
    }

    public String remove(String item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if(!stringList[i].equals(item)){
                throw new IllegalArgumentException("Нет такой строки в массиве");
            }else{
                stringList[i] = null;
            }
        }
        return null;
    }

    public String remove(int index){
        return stringList[index] = null;
    }

    public boolean contains(String item){
        if(item == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if(stringList[i] != null && stringList[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item){
        for (int i = 0; i < stringList.length; i++) {
            if(stringList[i] != null && stringList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item){
        for (int i = stringList.length -1; i >+ 0; i--) {
            if(stringList[i] != null && stringList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public String get(int index){
        return stringList[index];
    }

    public boolean equals(StringList otherList){
        if(otherList == null){
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if(stringList[i] != null && otherList.get(i) != null){
                if(!stringList[i].equals(otherList.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public int size(){
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if(stringList[i] != null){
                factSize++;
            }
        }
        return factSize;
    }

    public boolean isEmpty(){
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                factSize++;
            }
        }
        return factSize == 0;
    }

    public void clear(){
        Arrays.fill(stringList,null);
    }

    public String[] toArray(){
        String[] strings = new String[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            strings[i] =  stringList[i];
        }
        return strings;
    }

    public String toString(){
        return "StringList{" +
                "stringList" + Arrays.toString(stringList) +
                ", size=" + size +
                "}";
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        StringList that = (StringList) o;
        return size == that.size && Arrays.equals(stringList, that.stringList);
    }

    public int hashcode(){
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(stringList);
        return result;
    }

}
