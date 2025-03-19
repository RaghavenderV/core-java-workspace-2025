package com.vodapally.practice2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ReadContentFrom3FilesUsingCompFut {

    public static void main(String[] args) throws InterruptedException {

        String filePath1 = "G://core-java-workspace-2025/src/main/resources/readme.txt";
        String filePath2 = "G://core-java-workspace-2025/src/main/resources/readme2.txt";
        String filePath3 = "G://core-java-workspace-2025/src/main/resources/readme3.txt";

        List<String> list = List.of(filePath1, filePath2, filePath3);
        System.out.println(list);

        //Read content from multiple files using Completable Future

        List<CompletableFuture<String>> futures = list.stream()
                .map(fileName -> CompletableFuture.supplyAsync(
                        () -> readFile(fileName))).toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenAccept(result -> {
            for (CompletableFuture<String> future : futures) {
                try {
                    String content = future.get();
                    System.out.println("File content: \n" + content);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        //main thread is waiting for other threads to finish their tasks
        allFutures.join();

    }

    private static String readFile(String fileName) {

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Thread.sleep(5000);
                content.append(line).append("\n");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error due to --> "+e);
        }
        return content.toString();
    }

}
