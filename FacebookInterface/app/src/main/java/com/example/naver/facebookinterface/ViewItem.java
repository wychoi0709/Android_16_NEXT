package com.example.naver.facebookinterface;

/**
 * Created by Naver on 2016-04-10.
 */
public class ViewItem {

    private String otherPerson; //언급된 사람, 좋아한 사람 등등

    private int writerPicture;  //글쓴이 사진
    private String writer;      //글쓴이 이름

    private int time;       //글쓴 시간
    private String location;   //장소
    private int scopeOfText;    //공개범위

    private  String content;    //내용
    private int link;           //링크사진

    private int likeCount;      //좋아요 수
    private int commentCount;   //댓글 수

    public ViewItem(String otherPerson,
                    int writerPicture, String writer,
                    int time, String location, int scopeOfText,
                    String content, int link,
                    int likeCount, int commentCount){
        this.otherPerson = otherPerson;
        this.writerPicture = writerPicture;
        this.writer = writer;
        this.time = time;
        this.location = location;
        this.scopeOfText = scopeOfText;
        this.content = content;
        this.link = link;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public String getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(String otherPerson) {
        this.otherPerson = otherPerson;
    }

    public int getWriterPicture() {
        return writerPicture;
    }

    public void setWriterPicture(int writerPicture) {
        this.writerPicture = writerPicture;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getScopeOfText() {
        return scopeOfText;
    }

    public void setScopeOfText(int scopeOfText) {
        this.scopeOfText = scopeOfText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
