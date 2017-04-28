
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReversedBinary {
    public static void main(String[] args) throws Exception {
        
         try {
            InputStream in = new FileInputStream("/File.txt");
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String read;
            
            while((read = br.readLine()) != null) {
                sb.append(read);
            }
            
            BufferedWriter out = null;
            try  
            {
                FileWriter fstream = new FileWriter("/Result.bin", true);
                out = new BufferedWriter(fstream);
                
                String str = sb.toString();
                String result = "";

                char[] resbin = str.toCharArray();
                out.newLine();
                for (int i=resbin.length-1; i>=0; i--) {
                    result = Integer.toBinaryString(resbin[i]);
                    out.write(Integer.toBinaryString(resbin[i]) + " ");
                }
                br.close();
            }
            catch (IOException e)
            {
                System.err.println("Error: " + e.getMessage());
            }
            finally
            {
                if(out != null) {
                    out.close();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
   }
    
}
