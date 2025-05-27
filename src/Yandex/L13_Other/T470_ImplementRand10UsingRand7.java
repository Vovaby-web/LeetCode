package Tasks.LeetCode.Yandex.L13_Other;
public class T470_ImplementRand10UsingRand7 {
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++)
      System.out.println(rand10());
  }
  public static int rand10() {
    int num;
    while (true) {
      int row = rand7();
      int col = rand7();
      num = (row - 1) * 7 + col;    // �������� ����� � ��������� �� 1 �� 49
      if (num <= 40) {              // ���������� ������ ����� �� 1 �� 40
        return 1 + (num - 1) % 10;  // ����������� � �������� �� 1 �� 10
      }
    }
  }
  public static int rand7() {
    return 1 + (int) (Math.random() * 7);
  }
}
