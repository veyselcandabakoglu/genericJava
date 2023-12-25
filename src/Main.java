package src;
public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        System.out.println("Dizi kapasitesi : " + list.getCapacity());
    
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);
        System.out.println("Eleman sayisi : " + list.size());
        list.set(1, 100);
        System.out.println(list.toString());
        

        MyList<String> list2 = new MyList<>();
        list2.add("J");
        list2.add("A");
        list2.add("V");
        list2.add("A");
        System.out.println(list2.toString());
    }
}