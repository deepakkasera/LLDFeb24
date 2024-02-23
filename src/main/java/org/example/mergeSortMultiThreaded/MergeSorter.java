package org.example.mergeSortMultiThreaded;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    private ExecutorService executorService;

    MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort  = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        //Merge Sort Logic
        int n = listToSort.size();

        if (n <= 1) {
            return listToSort;
        }

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();

        for (int i = 0; i < n/2; i++) {
            leftHalf.add(listToSort.get(i));
        }

        for (int i = n/2; i < n; i++) {
            rightHalf.add(listToSort.get(i));
        }
        //sort left and right halves in different threads.

        MergeSorter leftMergeSorter = new MergeSorter(leftHalf, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightHalf, executorService);

        //ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> leftSortedListFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedListFuture = executorService.submit(rightMergeSorter);

        //Merge.
        List<Integer> leftSortedList = leftSortedListFuture.get(); // Blocking call.
        List<Integer> rightSortedList = rightSortedListFuture.get(); // Blocking call.

        int i = 0, j = 0;
        List<Integer> sortedList = new ArrayList<>();

        while(i < leftSortedList.size() && j < rightSortedList.size()) {
            if (leftSortedList.get(i) < rightSortedList.get(j)) {
                sortedList.add(leftSortedList.get(i));
                i++;
            } else {
                sortedList.add(rightSortedList.get(j));
                j++;
            }
        }

        while (i < leftSortedList.size()) {
            sortedList.add(leftSortedList.get(i));
            i++;
        }

        while (j < rightSortedList.size()) {
            sortedList.add(rightSortedList.get(j));
            j++;
        }

        return sortedList;
    }
}
