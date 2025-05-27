// https://leetcode.com/problems/design-an-atm-machine/solutions/
package Tasks.LeetCode.Yandex.L7_GreedyProblems;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class T2241_DesignAnATMMachine {
  // Сложность O(1)
  static class ATM {
    Map<Integer, Integer> bank;
    public ATM() {
      bank = new HashMap<>();
      for (int i = 0; i < 5; i++)
        bank.put(i, 0);
    }
    public void deposit(int[] banknotesCount) {
      for (int i = 0; i < 5; i++)
        bank.put(i, bank.get(i) + banknotesCount[i]);
    }
    public int[] withdraw(int amount) {
      int[] banknotes = {20, 50, 100, 200, 500};
      int[] receiving = new int[5];
      for (int i = 4; i >= 0; i--) {
        receiving[i] = Math.min(amount / banknotes[i], bank.get(i));
        amount -= receiving[i] * banknotes[i];
      }
      if (amount != 0)
        return new int[]{-1};
      else {
        for (int i = 0; i < 5; i++)
          bank.put(i, bank.get(i) - receiving[i]);
        return receiving;
      }
    }
  }
  public static void main(String[] args) {
    ATM obj = new ATM();
    obj.deposit(new int[]{0, 0, 1, 2, 1});
    System.out.println(Arrays.toString(obj.withdraw(600)));
    obj.deposit(new int[]{0, 1, 0, 1, 1});
    System.out.println(Arrays.toString(obj.withdraw(600)));
    System.out.println(Arrays.toString(obj.withdraw(550)));
  }
}
