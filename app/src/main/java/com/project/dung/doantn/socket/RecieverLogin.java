package com.project.dung.doantn.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;



/**
 * Created by Dung on 4/17/2017.
 */

public class RecieverLogin extends Thread {
    Socket socket;
    public RecieverLogin(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            UserLogin use = (UserLogin) in.readObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

