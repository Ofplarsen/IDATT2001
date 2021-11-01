package edu.ntnu.idatt2001.network;

import java.util.ArrayList;

public class PhotoPost {
    private String username;
    private String filename;
    private String caption;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public PhotoPost(String username, String filename, String caption) {
        this.username = username;
        this.filename = filename;
        this.caption = caption;
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

    public String getFilename() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void display(){
        System.out.println(username);
        System.out.println(" [" + filename + "]");
        System.out.println(" "+ caption);
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
