package files;

import java.io.*;

public class FileTask1 {
    private static File mediaCache = new File("C:\\Users\\1\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Media Cache");
    private static File cache = new File("C:\\Users\\1\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache");


    public static void doAudioPiracy(File resDir) {
        if (!resDir.exists())
            resDir.mkdir();

        for (final File fileEntry : mediaCache.listFiles()) {
            if (fileEntry.isFile() && fileEntry.length() == 1048576) {
                String name = fileEntry.getName();
                System.out.println(name + " ");

                File dest = new File(resDir,name+".mp3");
                try {
                    copyFileUsingStream(fileEntry, dest);
                }
                catch (IOException ioExc){
                    System.out.println("failed with " + name);
                }
            }
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
