package inout;
import java.io.*;

public class StreamService {
  public static void streamCopy(InputStream is, OutputStream os) throws IOException {
      if(is == null || os == null) throw new IllegalArgumentException("Null stream pointer");
      int readByte = 0;
      byte [] buffer = new byte[1024*1024];
      for(;(readByte = is.read(buffer)) > 0;){
         os.write(buffer, 0, readByte);
      }
  }
  public static void fileCopy(File original, File copy) throws IOException{
      try{
          FileInputStream is = new FileInputStream(original);
          FileOutputStream os = new FileOutputStream(copy);
          streamCopy(is,os);
      }catch (IOException e){
          throw e;
      }
  }
}
