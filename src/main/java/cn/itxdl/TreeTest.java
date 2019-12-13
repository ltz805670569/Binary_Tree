package cn.itxdl;

public class TreeTest {
    public static void main(String[] args) {
        TreeSortList tl = new TreeSortList();
        tl.add(100);
        tl.add(20);
        tl.add(22);
        tl.add(88);
        tl.add(45);
        tl.add(200);
        tl.add(210);
        tl.add(280);
        tl.add(7);
        tl.add(6);
        tl.print();
        System.out.println();
        TreeSortList.Node node = tl.get(7);
        System.out.println(node);
        tl.remove(22);
        tl.print();
    }
}
