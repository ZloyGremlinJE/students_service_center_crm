package com.jm.students.service.util;

public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text);
}
