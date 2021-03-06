package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();   //Object[]
        list.add("1");
        Vector<String> vector = new Vector<>();       //Object[]
        LinkedList<String> linkedList = new LinkedList<>(); //双向链表
        linkedList.add("a");
        HashSet<String> hashSet = new HashSet<>();    //HashMap
        hashSet.add("1");
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();//LinkedHashMap
        linkedHashSet.add(new Object());
        TreeSet<String> treeSet = new TreeSet<>();//红黑树
        treeSet.add("1");
        HashMap<String, String> hashMap = new HashMap<>();//数组+链表   8<length<64 对数组进行扩容 >64 转化为红黑树
        //treeifyBin方法 数据结构的转换
        hashMap.put("a", "a");
        Hashtable<String, String> hashtable = new Hashtable<>();//Entry[] 数组+链表  但是不存在底层数据结构转换的情况
        hashtable.put("a", "");// value不能为空
        TreeMap<String, String> treeMap = new TreeMap<>();//红黑树
        treeMap.put("a", "n");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", "a");
        PriorityQueue<Object> queue = new PriorityQueue<>();
        queue.add(new Object());//不支持存储null值
        Stack<String> stack=new Stack();
        stack.push("1");


        int temp = 155645643;
        int length = 128;  //如果length的值为2的幂次方 那么 temp%length和temp&(length-1)的值相同 且使用&运算的效率更高
        System.out.println(temp % length);
        System.out.println(temp & (length - 1));
        hashMap.entrySet().iterator();
        hashMap.keySet().iterator();
        hashMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });



        int oldCapacity = 9;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println((oldCapacity >> 1));
        System.out.println(newCapacity);

    }

//    private void grow(int minCapacity) {
//        // overflow-conscious code
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
}
