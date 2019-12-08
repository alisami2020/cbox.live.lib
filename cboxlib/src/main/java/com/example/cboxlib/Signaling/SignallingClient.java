package com.example.cboxlib.Signaling;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.cboxlib.Signaling.SignalingInterface;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 *
 *
 */
public class SignallingClient {

   private SignalingInterface callback;
   private String roomName;
   private int ID;
   private String name;
   private Context mContext;
   public static Socket socket;


    /**
     *
     * @param mContext
     * @param roomName
     * @param LoginID
     * @param name
     * @param signalingInterface
     */
    public void init(Context mContext ,String roomName ,int LoginID ,String name ,SignalingInterface signalingInterface) throws URISyntaxException {
        this.callback = signalingInterface;
        this.roomName = roomName;
        this.ID = LoginID;
        this.mContext = mContext;
        this.name = name;
        IO.Options options = new IO.Options();
        String result = "";



        //TODO : Initlize for Socket To connect To Server
        StringBuilder query =
                new StringBuilder("user_id=" + ID + "&username=" + name + "&room=" + roomName + "&url=" + "https://c-box.live:5000" + "&title=" + "my title" + "&type=" + 1);
        result = query.toString();
        options.query = result;
        socket = IO.socket("https://c-box.live:5050", options);
        if (!socket.connected()) {

            socket.connect();
        }

        ListenToMsg();
    }

    public void ListenToMsg()
    {
        //ToDo:Listen to msg
        socket.on("listenMessage", args -> {

            Log.e("msg",args[0].toString());
            Log.e("name",args[1].toString());
            Log.e("type",args[2].toString());
            Log.e("visitorid",args[3].toString());
            Log.e("notyid",args[4].toString());
            callback.Onmsgrecieved(args[0].toString(),args[1].toString() ,args[2].toString(),args[3].toString(),args[4].toString());

        });
    }





}
