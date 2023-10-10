package clone;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExample {
    // public static void main(String[] args) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     list.add(1);
    //     list.add(2);
    //     list.add(3);
    //     Iterator<Integer> iterator = list.iterator();
    //     while (iterator.hasNext()) {
    //         Integer item = iterator.next();
    //         if (item == 2) {
    //             list.remove(item); // 在迭代时删除元素
    //         }
    //     }
    // }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == 2) {
                iterator.remove(); // 使用迭代器的 remove() 方法删除元素
            }
        }
    }
}
