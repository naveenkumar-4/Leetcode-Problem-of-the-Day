import java.util.Arrays;

class Person {
    String name;
    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}

public class Solution {
    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people_array = new Person[n];
        for (int i = 0; i < n; i++) {
            people_array[i] = new Person(names[i], heights[i]);

        }
        Arrays.sort(people_array, (a, b) -> {
            return b.height - a.height;
        });

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = people_array[i].name;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] names = { "Mary", "John", "Emma" };
        int[] heights = { 180, 165, 170 };
        String[] res = sortPeople(names, heights);
        System.out.println(Arrays.toString(res));
    }
}