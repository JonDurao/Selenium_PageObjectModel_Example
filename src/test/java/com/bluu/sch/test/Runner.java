package com.bluu.sch.test;

import com.bluu.sch.test.tests.TestAdministracionGeneralResto;
import com.bluu.sch.test.utils.ChromeDriverBase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// Class to use as main in a Jar creation to run the tests independently
public class Runner {
    public static void main(String[] args) {
        System.out.println( "Schaman Test Library" );
        System.out.println( "-------------------------------------------------------------------------------------------" );

        if (args.length > 0){
            System.out.println("Setting values");
            ChromeDriverBase.setChromeDriver(args[0]);
            ChromeDriverBase.setDownloadFolder(args[1]);
            ChromeDriverBase.setUrlSchaman(args[2]);
        } else {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
                System.out.println("Enter the path to your Chrome driver:");
                ChromeDriverBase.setChromeDriver(br.readLine());

                System.out.println("Enter your local Downloads folder:");
                ChromeDriverBase.setDownloadFolder(br.readLine());

                System.out.println("Enter your Schaman URL:");
                ChromeDriverBase.setUrlSchaman(br.readLine());
            } catch (IOException ioe){}
        }

        System.out.println( "-------------------------------------------------------------------------------------------" );

        Reflections reflections = new Reflections("com.bluu.sch.test.tests");
        Set<Class<? extends ChromeDriverBase>> allClasses = reflections.getSubTypesOf(ChromeDriverBase.class);

        int max = 4;

        for (int i = 0; i <= max; i++){
            Runnable r = new ThreadMine(TestAdministracionGeneralResto.class);
            new Thread(r).start();

            for (Class c : allClasses){
                //Runnable r = new ThreadMine(c);
                //new Thread(r).start();
                System.out.println( "-------------------------------------------------------------------------------------------" );
            }
        }
    }

    public static class ThreadMine implements Runnable {
        Class c;
        Result result;

        ThreadMine(Class c){
            this.c = c;
        }

        @Override
        public void run() {
            System.out.println(c.getSimpleName());

            JUnitCore core = new JUnitCore();
            result = core.run(c);
            System.out.println(result.wasSuccessful() ? "Test " + c.getSimpleName() + " terminado con exito" : "Test " + c.getSimpleName() + " termino con " + result.getFailureCount() + " fallos");
        }
    }
}
