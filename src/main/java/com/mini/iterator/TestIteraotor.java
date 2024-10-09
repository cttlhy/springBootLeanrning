package com.mini.iterator;



public class TestIteraotor {

    public static void main(String[] args) {

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//
//        Iterator<Integer> iterator = new ArrayIterator<>(arrayList);
//        while (iterator.hasNext()){
//            System.out.println("args = " + iterator.currentItem());
//            iterator.next();
//        }

//        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//
//        Iterator<Integer> iterator1 = linkedList.iterator();
//        while (iterator1.hasNext()){
//            System.out.println("args = " + iterator1.currentItem());
//            iterator1.next();
//        }

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        Iterator<Integer> iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            System.out.println("args = " + iterator.currentItem());
//            iterator.next();
//        }
        iterator.next();
        arrayList.remove(1);
        System.out.println("最终结果："+arrayList.get(0));
    }
}
