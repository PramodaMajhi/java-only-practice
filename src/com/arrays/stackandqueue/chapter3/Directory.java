package com.arrays.stackandqueue.chapter3;


import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/*
 Listing files. A Unix directory is a list of files and directories.
 Program Directory.java takes the name of a directory as a command-line argument
 and prints out all of the files contained in that directory
 (and any subdirectories) in level-order. It uses a queue.
 */
public class Directory {
    public static void main(String[] args) {
        String dir = "/Users/pramoda/Documents";
        Queue<File> queue = new LinkedList<File>();
        File root = new File(dir);
        if(!root.exists()) {
            System.out.println(dir + "does not exits");
            return;
        }

        queue.add(root);
        while(!queue.isEmpty()) {
            File x = queue.poll();
            if(!x.isDirectory()) {
                System.out.println(x.length() + ":\t" +x);
            } else {
                File[] files = x.listFiles();
                if(files!=null) {
                    for (int i = 0; i <files.length ; i++) {
                        queue.add(files[i]);
                    }
                }
            }
        }

    }
}

