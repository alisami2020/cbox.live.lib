package com.example.cboxlivelib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cboxlib.Signaling.SignalingInterface;
import com.example.cboxlib.Signaling.SignallingClient;

import org.json.JSONObject;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements SignalingInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignallingClient signallingClient =new SignallingClient();

        try {
            signallingClient.init(getApplicationContext(),"logappshosting",1,"admin",this);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onRemoteHangUp(String msg) {

    }

    @Override
    public void onOfferReceived(JSONObject data) {

    }

    @Override
    public void onAnswerReceived(JSONObject data) {

    }

    @Override
    public void onIceCandidateReceived(JSONObject data) {

    }

    @Override
    public void onTryToStart() {

    }

    @Override
    public void onCreatedRoom() {

    }

    @Override
    public void onJoinedRoom() {

    }

    @Override
    public void onNewPeerJoined() {

    }

    @Override
    public void onRoomFull() {

    }

    @Override
    public void onFileRecieve(String name, String Visitor_id, String notification_id) {

    }

    @Override
    public void requestCall(String username, String product_name, int id, String ip) {

    }

    @Override
    public void VideoCall(String id, String name, String room) {

    }

    @Override
    public void Onmsgrecieved(String message, String name, String type, String Vidsitor_id, String Notification_id) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void visitoradd(String id) {

    }

    @Override
    public void visitorleft(String name) {

    }

    @Override
    public void CallCanceled() {

    }

    @Override
    public void CallID(String name, String Visitorid) {

    }

    @Override
    public void VoiceCall(String s, String s1, String room) {

    }
}
