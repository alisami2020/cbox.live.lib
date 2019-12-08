package com.example.cboxlib.Signaling;

import org.json.JSONObject;

public interface SignalingInterface {



    void onRemoteHangUp(String msg);

    void onOfferReceived(JSONObject data);

    void onAnswerReceived(JSONObject data);

    void onIceCandidateReceived(JSONObject data);

    void onTryToStart();

    void onCreatedRoom();

    void onJoinedRoom();

    void onNewPeerJoined();

    void onRoomFull();

    void onFileRecieve(String name,String Visitor_id,String notification_id);

    void requestCall(String username, String product_name, int id, String ip);

    void VideoCall(String id, String name,String room);

    /**
     *
     * @param message
     * @param name
     * @param type
     * @param Vidsitor_id
     * @param Notification_id
     */
    void Onmsgrecieved(String message, String name,String type,String Vidsitor_id ,String Notification_id);

    void visitoradd(String id);

    void visitorleft(String name);

    void CallCanceled();

    void CallID(String name,String Visitorid);

    void VoiceCall(String s, String s1,String room);
}