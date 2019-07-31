package com.alexcompany.springsecurity62.service;

public interface MailService {

    void send(String context, String email, String body);
}
