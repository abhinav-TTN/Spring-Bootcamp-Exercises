package org.example;

import com.abhinav.utils.DoSomething;
public class App {
    public static void main( String[] args ) {

        // Creating object of my util class
        DoSomething doSomething = new DoSomething();
        // Calling method from inside my custom dependency
        doSomething.printSomethingFromDependency();
    }
}
