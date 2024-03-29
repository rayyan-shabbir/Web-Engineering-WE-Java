import java.io.*;

public class Streams_Byte_BufferedOutputStream_02 {

    public void writeToFile(String filename) {

        BufferedOutputStream bufferedOutput = null;

        try {
            //Construct the BufferedOutputStream object
            bufferedOutput = new BufferedOutputStream(new FileOutputStream(filename));

            //Start writing to the output stream
            bufferedOutput.write("Hello How are you.......".getBytes());

	    System.out.println("File has written successfuly...");

	   //close BOS so that it can write bytes on FOS
	    bufferedOutput.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Streams_Byte_BufferedOutputStream_02().writeToFile("test.txt");
    }
}
