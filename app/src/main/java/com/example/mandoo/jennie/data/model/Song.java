package com.example.mandoo.jennie.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    private long mDuration;
    private int mId;
    private String mTitle;
    private String mUri;
    private String mUsername;
    private String mAlbumArt;

    public Song() {

    }

    private Song(Parcel in) {
        mDuration = in.readLong();
        mId = in.readInt();
        mTitle = in.readString();
        mUri = in.readString();
        mUsername = in.readString();
        mAlbumArt = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mDuration);
        dest.writeInt(mId);
        dest.writeString(mTitle);
        dest.writeString(mUri);
        dest.writeString(mUsername);
        dest.writeString(mAlbumArt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getAlbumArt() {
        return mAlbumArt;
    }

    public void setAlbumArt(String albumArt) {
        mAlbumArt = albumArt;
    }
}
