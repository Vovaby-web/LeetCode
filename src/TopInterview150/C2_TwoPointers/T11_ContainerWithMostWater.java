package TopInterview150.C2_TwoPointers;
public class T11_ContainerWithMostWater {
  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,2,4,3}));
  }
  public static int maxArea(int[] height) {
    // Левая граница
    int left = 0;
    // Правая граница
    int right = height.length - 1;
    // Наш результат
    int result = 0;
    // Высота воды
    int h;
    while (left < right) {
      // Высота воды будет - минимальный столбик
      h = Math.min(height[left], height[right]);
      // Сравниваем предыдущий результат и текущий результат
      result = Math.max(result, h * (right - left));
      // Если следующий столбец слева меньше нашей высоты, то смысла проверять его нет
      // переходим к следующему столбцу
      while (left < right && height[left] <= h)
        left++;
      // Если следующий столбец справа меньше нашей высоты, то смысла проверять его нет
      // переходим к следующему столбцу
      while (left < right && height[right] <= h)
        right--;
    }
    return result;
  }
}
