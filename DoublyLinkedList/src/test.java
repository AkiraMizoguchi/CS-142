public class test {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> a=new DoublyLinkedList<>();
        DoublyLinkedList<Integer> b=new DoublyLinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        b.add(2);
        b.add(2);

        System.out.println(a.remove(1));
    }
}
