package org.example.mergeSortMultiThreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(3, 2, 1, 4, 6, 8, 7, 5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(listToSort, executorService);

        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
    }
}

/*
Steps :-

1. Create the Sorter Task.
2. Make this implement Callable interface.
3. Implement call method with MergeSort logic.

 */
