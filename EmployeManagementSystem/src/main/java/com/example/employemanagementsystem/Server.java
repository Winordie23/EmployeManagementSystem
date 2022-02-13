package com.example.employemanagementsystem;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverScocet;
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private static String username;

    public Server(ServerSocket serverSocket){

        try {
            this.serverScocet=serverSocket;
            this.socket= serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e){
            System.out.println("Error creating server....");
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(String sendToClient){
        try{
            bufferedWriter.write(sendToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
                           }
        catch (IOException e){
            System.out.println("error sending message to client..");
            e.printStackTrace();
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void recieveMessageFromClient(VBox vBox){
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (socket.isConnected()){
                    try{
                        String msgFromClient = bufferedReader.readLine();
                       serverController.addLabel(msgFromClient,vBox);
                    }
                    catch (IOException e){
                        System.out.println("error reciving message from client..");
                        e.printStackTrace();
                        closeEverything(socket,bufferedReader,bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(bufferedWriter!=null){
                bufferedWriter.close();
            }
            if(socket!=null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
