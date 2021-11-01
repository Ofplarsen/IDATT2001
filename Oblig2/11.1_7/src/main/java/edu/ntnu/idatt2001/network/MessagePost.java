package edu.ntnu.idatt2001.network;

import java.util.ArrayList;

public class MessagePost {
    private String username;
    private String message;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public MessagePost(String username, String message) {
        this.username = username;
        this.message = message;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    public void like(){
        likes++;
    }

    public void unlike(){
        if(likes > 0){
            likes--;
        }
    }

    public void addComment(String text){
        comments.add(text);
    }

    public String getText(){
        return message;
    }

    public long getTimestamp(){return timestamp;}

    public void display(){
        System.out.println(username);
        System.out.println(message);
        System.out.print(timeString(timestamp));

        if(likes > 0){
            System.out.println(" - " + likes + " people like this.");
        }else{
            System.out.println();
        }

        if(comments.isEmpty()){
            System.out.println("  No comments.");
        }else{
            System.out.println(("  " + comments.size() + " comment(s). Click here to view"));
        }
    }

    private String timeString(long time){
        long current = System.currentTimeMillis();
        long pastMillis = current-time;
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes> 0){
            return minutes + " minutes ago";
        }else{
            return seconds + " seconds ago";
        }
    }
}
