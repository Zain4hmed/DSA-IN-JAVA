import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> findCombinations(int sumTotal, int numElements) {
        List<List<Integer>> combinations = new ArrayList<>();
        helper(sumTotal, numElements, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void helper(int total, int k, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (k == 1) {
            currentCombination.add(total);
            combinations.add(new ArrayList<>(currentCombination));
            currentCombination.remove(currentCombination.size() - 1);
        } else {
            for (int i = 0; i <= total; i++) {
                currentCombination.add(i);
                helper(total - i, k - 1, currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = findCombinations(5, 3);
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}
