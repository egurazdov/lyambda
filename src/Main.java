import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 20, 3, 4, 5, 6, 7, 8, 9};
        Expression expression = (a) -> a % 2 == 0;
        System.out.println(sumOfEven(array, expression));

        List<String> list = new ArrayList<>();
        list.add("blue");
        list.add("purple");
        list.add("red");
        list.add("black");
        ExpressionTwo expressionTwo = (a, b) -> a.length() > b.length();
        System.out.println(longestElement(list, expressionTwo));
    }

    public static String longestElement(List<String> list, ExpressionTwo expression) {
        String result = list.getFirst();
        for (int i = 1; i < list.size() ; i++) {

            if (expression.isLonger(list.get(i), result)) {
                result = list.get(i);
            }
        }
        return result;
    }

    public static int sumOfEven(int[] array, Expression expression) {
        int result = 0;
        for (int element : array) {
            if (expression.isEqual(element)) {
                result += element;
            }
        }
        return result;
    }
}

interface Expression {
    boolean isEqual(int a);
}

interface ExpressionTwo {
    boolean isLonger (String a, String b);
}