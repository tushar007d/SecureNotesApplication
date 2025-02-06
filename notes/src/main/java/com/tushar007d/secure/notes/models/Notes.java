package com.tushar007d.secure.notes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Lob annotation is used to store large volume of data such as text/binary
    //binary data such as images/videos/audio
    @Lob
    private String content;

    private String ownerUsername;

    public Notes(Long id, String content, String ownerUsername) {
        this.id = id;
        this.content = content;
        this.ownerUsername = ownerUsername;
    }


    public Notes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                '}';
    }
}
