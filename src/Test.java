import java.util.*;
public class Test {
  static class Frends {
    String name;
    int label;
    boolean spic;
    List<Frends> frends;
    int fruit;
    public Frends(String name) {
      this.name = name;
      spic = false;
      fruit = 0;
      frends = new ArrayList<>();
      label=0;
    }
  }
  public static void main(String[] args) {
    //                  0       1         2      3       4        5       6        7
    String[] name = {"Вова", "Анудж", "Пегги", "Боб", "Алиса", "Клэр", "Том", "Джонни"};
    List<Frends> list = new ArrayList<>();
    for (int i = 0; i < name.length; i++) {
      list.add(new Frends(name[i]));
    }
    list.get(0).frends.add(list.get(3));
    list.get(0).frends.add(list.get(5));
    list.get(0).frends.add(list.get(4));
    list.get(1).frends.add(list.get(3));
    list.get(2).frends.add(list.get(3));
    list.get(2).frends.add(list.get(4));
    list.get(3).frends.add(list.get(0));
    list.get(3).frends.add(list.get(2));
    list.get(3).frends.add(list.get(1));
    list.get(4).frends.add(list.get(0));
    list.get(4).frends.add(list.get(2));
    list.get(5).frends.add(list.get(0));
    list.get(5).frends.add(list.get(6));
    list.get(5).frends.add(list.get(7));
    list.get(6).frends.add(list.get(5));
    list.get(7).frends.add(list.get(5));
    list.get(3).fruit=1;
    Queue<Frends> queue=new ArrayDeque<>();
    int count=0;
    list.get(0).spic=true;
    queue.add(list.get(0));
    while(!queue.isEmpty()){
     Frends frends=queue.poll();
     frends.spic=true;
     if (frends.fruit==0){
      for (int i=0;i<frends.frends.size();i++) {
        if(!frends.frends.get(i).spic) {
          frends.frends.get(i).label=frends.label+1;
          queue.add(frends.frends.get(i));
        }
      }
     } else {
       count=frends.label;
       break;
     }
    }
    System.out.println(count);
  }
}
