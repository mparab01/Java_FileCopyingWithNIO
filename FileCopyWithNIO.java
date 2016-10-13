/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filecopywithnio;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
/**
 *
 * @author Milind
 */
public class FileCopyWithNIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File sourceFile = new File("C:\\temp_Java\\source.txt");
        File Destination = new File("C:\\temp_Java\\destination.txt");
        
        FileChannel src = null;
        FileChannel dst = null;
        
        
        try{
            if (!Destination.exists()){
                 Destination.createNewFile();
            }
            
           src = new FileInputStream(sourceFile).getChannel();
           dst = new FileOutputStream(Destination).getChannel();
           dst.transferFrom(src, 0, dst.size());
           
        }
        
        catch (IOException e){
            System.out.println("Exception has been occured");
        
        }
       
        finally{
            try{
                if (src!=null){
                    src.close();
                }
                if (dst!=null){
                    dst.close();
                }
            }
            catch (IOException e){}
        }
        
        
    }
    
}
