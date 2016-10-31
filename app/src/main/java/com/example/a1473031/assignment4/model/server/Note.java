package com.example.a1473031.assignment4.model.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;

/**
 * Created by 1473031 on 2016-10-28.
 */
public class Note {

    public static Note parse(String json){
        Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                    .create();

        Note note = gson.fromJson(json, Note.class);
        return note;
    }



    public static Note[] parseArray(String json){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Note[] notes = gson.fromJson(json, Note[].class);
        return notes;
    }

    public static Note[] parseArray2(String json){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        NoteArray noteArray = gson.fromJson(json, NoteArray.class);
        return NoteArray.notes;
    }

    private static class NoteArray {
        private static Note[] notes;
    }


    private static class _links{
        private static class self{
            private String href;

            //getter setter
        }

        private static class note{
            private String href;
            //getter setter
        }

        private static class createdBy{
            private String href;
            //getter setter
        }

    }

    private String title;
    private String body;
    private int category;
    private boolean hasReminder;
    private Date reminder;
    private Date created;
    private String createdBy;
   // private _links links;

  //  public Note() { links = new _links(); }


    public boolean isHasReminder() {
        return hasReminder;
    }

    public void setHasReminder(boolean hasReminder) {
        this.hasReminder = hasReminder;
    }



    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    public Date getReminder() {
        return reminder;
    }

    public void setReminder(Date reminder) {
        this.reminder = reminder;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String format(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .serializeNulls()
                .create();
        return gson.toJson(this);
    }

}
