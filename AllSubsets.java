import java.util.ArrayList;

public class AllSubsets {
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add an empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static void main(String[] args) {
        AllSubsets subsets = new AllSubsets();
        ArrayList<Integer> inputSet = new ArrayList<Integer>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);

        ArrayList<ArrayList<Integer>> allSubsets = subsets.getSubsets(inputSet, 0);

        System.out.println("All Subsets:");
        for (ArrayList<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}


//javac AllSubsets.java
//java AllSubsets
