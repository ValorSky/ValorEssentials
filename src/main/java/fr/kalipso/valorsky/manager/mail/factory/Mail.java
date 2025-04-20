package fr.kalipso.valorsky.manager.mail.factory;

import lombok.Data;

import java.util.UUID;

public @Data class Mail {

    public UUID id;
    public String contents;

    public Mail(UUID id, String contents)
    {
        this.id = id;
        this.contents = contents;
    }
}
