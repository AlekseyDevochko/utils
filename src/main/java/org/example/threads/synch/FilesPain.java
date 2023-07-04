package org.example.threads.synch;

import org.example.threads.ThreadUtils;

import java.io.*;

public class FilesPain {

    private File file;

    public FilesPain(File file){
        this.file = file;
    }

    public void readFile(File file){
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file))) {
            int elem;
            StringBuilder sb = new StringBuilder();
            while ((elem = stream.read()) != -1){
                sb.append((char) elem);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFile(File file){
//        ThreadUtils.logJob(Thread.currentThread().getName() + " Write in file");
//        try {
//            FileWriter fw = new FileWriter(file);
//            fw.(Thread.currentThread().getName() + " ");
//            for (char ch :
//                    Thread.currentThread().getName().toCharArray()) {
//                fw.append(ch);
//            }
//
//            fw.write(Thread.currentThread().getName() + " ");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        ThreadUtils.logJob(Thread.currentThread().getName() + " Write in file");
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            stream.write((byte)Thread.currentThread().getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }
}

class PainMaker extends Thread {

    private FilesPain fp;

    public PainMaker(FilesPain fp, String string){
        setName(string);
        this.fp = fp;
    }

    @Override
    public void run() {

        ThreadUtils.logBegin();

        for (int i = 0; i < 10; i++) {
            fp.writeFile(fp.getFile());
        }

        ThreadUtils.logFinish();
    }
}

class MainPain{
    public static void main(String[] args) {
        File file = new File("File.txt");
        FilesPain fp = new FilesPain(file);


        new PainMaker(fp, "PainMaker1").start();
        new PainMaker(fp, "PainMaker2").start();
        new PainMaker(fp, "PainMaker3").start();
        new PainMaker(fp, "PainMaker4").start();


    }
}
