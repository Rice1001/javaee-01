package com.javaee.code.model;

import java.util.Date;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/13 19:33
 */
public class Homework {

    private long id;

    private String title;

    private String content;

    private Date create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
