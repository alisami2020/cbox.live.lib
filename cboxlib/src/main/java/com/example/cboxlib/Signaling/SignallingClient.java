package com.example.cboxlib.Signaling;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.cboxlib.Signaling.SignalingInterface;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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

    @SuppressLint("TrustAllX509TrustManager")
    private final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }

        public void checkClientTrusted(X509Certificate[] chain,
                                       String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain,
                                       String authType) {
        }
    }};

    /**
     *
     * @param mContext
     * @param roomName
     * @param LoginID
     * @param name
     * @param signalingInterface
     */
    public void init(Context mContext ,String roomName ,int LoginID ,String name ,SignalingInterface signalingInterface) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        this.callback = signalingInterface;
        this.roomName = roomName;
        this.ID = LoginID;
        this.mContext = mContext;
        this.name = name;
        IO.Options options = new IO.Options();
        String result = "";



        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, trustAllCerts, null);
        IO.setDefaultHostnameVerifier((hostname, session) -> true);
        IO.setDefaultSSLContext(sslcontext);
        //set the socket.io url here http://sicket.log-apps.com/
//            socket = IO.socket("https://85.10.200.252:8001");
        //  socket = IO.socket("https://c-box.live:5050");

        //ToDO : emit for data

        Log.e("rrom", roomName);
        StringBuilder query =
                new StringBuilder("user_id=" + ID + "&username=" + name + "&room=" + roomName + "&url=" + "https://c-box.live:5000" + "&title=" + "my title" + "&type=" + 1);

        result = query.toString();
        options.query = result;

        socket = IO.socket("https://c-box.live:5050", options);
        if (!socket.connected()) {

            socket.connect();
        }

        socket.connect();

        ListenToMsg();
    }

    public void ListenToMsg()
    {
        //ToDo:Listen to msg
        socket.on("listenMessage", args -> {


            callback.Onmsgrecieved(args[0].toString(),args[1].toString() ,args[2].toString(),args[3].toString(),args[4].toString());

        });
    }





}
