package com.vodapally.java11;

import jdk.jfr.Configuration;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.Duration;

public class JavaFlightRecorder {
    public static void main(String[] args) {
        // Create a new recording
        try (Recording recording = new Recording(Configuration.getConfiguration("default"))){
            // Set the name and duration of the record
            recording.setName("MyFirstRecording");
            recording.setDuration(Duration.ofSeconds(10));

            // Start the recording
            recording.start();
            System.out.println("Recording started...");
            
            // Simulate some workload
            for (int i = 0; i < 100000; i++) {
                Math.sin(i);
            }

            // Stop the recording
            recording.stop();
            System.out.println("Recording stopped..");

            // Save the recording to a file
            Path recordingFile = Paths.get("src/main/resources/mhfirstrecording.jfr");
            recording.dump(recordingFile);
            System.out.println("Recording saved to : "+recordingFile.toAbsolutePath());

            // Read and print events from the recording file
            try (RecordingFile recordingFileReader = new RecordingFile(recordingFile)){
                while (recordingFileReader.hasMoreEvents()){
                    RecordedEvent recordedEvent = recordingFileReader.readEvent();
                    System.out.println(recordedEvent);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException | ParseException e) {
            System.out.println("Due to : "+e);
        }
    }
}
