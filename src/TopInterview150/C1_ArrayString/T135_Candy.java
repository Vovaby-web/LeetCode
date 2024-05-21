// https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T135_Candy {
  public static void main(String[] args) {
    System.out.println(candy(new int[]{3, 2, 1, 1, 2, 3}));
  }
  public static int candy(int[] ratings) {
    int n = ratings.length;
    int up = 0;                 // количество увеличивающихся рейтингов
    int down = 0;               // количество уменьшающихся рейтингов
    int ans = 1;                // Общее количество розданных конфет
    for (int i = 1; i < n; i++) {
      // Проходим по массиву ratings начиная с 1 индекса и сравниваем текущий рейтинг с предыдущим.
      if (ratings[i - 1] < ratings[i]) {
        up++;
        down = 0;
        ans += up + 1;
      } else if (ratings[i] == ratings[i - 1]) {
        up = 0;
        down = 0;
        ans++;
      } else {
       // Количество конфет, которые мы недодали предыдущим детям
        down++;
        // Недодали down конфет
        ans += down + (up >= down ? 0 : 1);
        up = 0;
      }
    }
    return ans;
  }
}
