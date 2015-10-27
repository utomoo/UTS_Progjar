/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author lenovo
 */
public class UTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try(Socket clientSocket = new Socket("10.151.34.155", 6666);
                PrintWriter out = 
                    new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                ){
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            byte[] buf = new byte[10];    
            String fromServer;
            String fromServer1;
            String fromUser;
            int len;
            
            fromServer = in.readLine();
            fromServer1 = in.readLine();
            System.out.println("Server: " +fromServer);
            System.out.println("Server: " +fromServer1);
            
            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
            while(true){
              //while((fromServer = in.readLine()) != null){
                    System.out.println("Test1");
                    fromServer = in.readLine();
                    System.out.println("Test3");
                    fromServer1 = in.readLine();
                    
                    System.out.println("Server: " +fromServer);
                    System.out.println("Server: " +fromServer1);
                  
                    fromUser = jawab(fromServer1);
                    //len = Integer.parseInt(fromUser);
                    //fromUser = stdIn.readLine();
                    if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println("Result:"+fromUser);
                    }
                    System.out.println("Test2");
            }
        }
       catch(UnknownHostException e){
           System.out.println("Server tidak ditemukan");
       }
    }

    private static String jawab(String fromServer1) {
        int hasil=0;
        String jawaban;
        String[] ans = fromServer1.split(" ");
        String part1 = ans[0];
        String part2 = ans[2];
        String part3 = ans[1];
        if(isNumeric(part1)==true){
            System.out.println(part1);
            System.out.println(part2);
            int nomer1 = Integer.parseInt(part1);
            int nomer2 = Integer.parseInt(part2);
            if(part3.equals("x")){
                hasil = nomer1 * nomer2;
            }
            else if(part3.equals(("+"))){
                hasil = nomer1 + nomer2;
            }
            else if(part3.equals("-")){
                hasil = nomer1 - nomer2;
            }
            else if(part3.equals("mod")){
                hasil = nomer1 % nomer2;
            }
            System.out.println(hasil);
            jawaban = Integer.toString(hasil);
        }
        else{
            jawaban ="GIVE UP";
        }
        
        
        
        return jawaban;
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    
}

