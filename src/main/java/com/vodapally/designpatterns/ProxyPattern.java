package com.vodapally.designpatterns;

// 1. Interface that both Real and Proxy classes will implement
interface Image{
    void display();
}

// 2. Real Subject - The actual object that does the heavy work
class RealImage implements Image{
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading "+fileName+" from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying "+fileName);
    }
}

// 3. Proxy - Controls access to the Real Subject
class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Lazy initialization: RealImage is only created when needed
        if (realImage==null){
            realImage=new RealImage(fileName);
        }
        realImage.display();
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        // Using proxy instead of real image directly
        Image image = new ProxyImage("test_image.jpg");

        // Image will be loaded from disk only on first display
        System.out.println("First call:");
        image.display();

        // Second call uses already loaded image (no loading)
        System.out.println("\nSecond call:");
        image.display();
    }
}
/*
The Proxy Pattern is a structural design pattern that provides a surrogate
or placeholder for another object to control access to it.
 */