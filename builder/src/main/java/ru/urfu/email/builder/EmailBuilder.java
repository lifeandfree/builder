package ru.urfu.email.builder;

import java.util.ArrayList;

public class EmailBuilder {

    private static class Builder implements IContent, IBuild {
        private EmailBuilder instance = new EmailBuilder();

        public Builder(String to) {
            instance.to = to;
        }

        @Override
        public EmailBuilder build() {
            if (instance.subject == null) {
                instance.subject = "";
            }
            if (instance.copyTo == null) {
                instance.copyTo = new ArrayList<>();
            }
            if (instance.from == null) {
                instance.from = "";
            }
            return instance;
        }

        @Override
        public IBuild content(String content) {
            instance.content = content;
            return this;
        }

        @Override
        public IBuild copyTo(String to) {
            if (instance.copyTo == null) {
                instance.copyTo = new ArrayList<>();
            }
            instance.copyTo.add(to);
            return this;
        }

        @Override
        public IBuild from(String from) {
            instance.from = from;
            return this;
        }

        @Override
        public IBuild subject(String subject) {
            instance.subject = subject;
            return this;
        }

    }

    public interface IBuild {
        EmailBuilder build();

        IBuild copyTo(String string);

        IBuild from(String string);

        IBuild subject(String subject);
    }

    public interface IContent {
        IBuild content(String content);
    }

    public static IContent to(String string) {
        return new EmailBuilder.Builder(string);

    }

    private String content;
    private ArrayList<String> copyTo;
    private String from;
    private String subject;
    private String to;

    private EmailBuilder() {
    }

    public String getContent() {
        return content;
    }

    public ArrayList<String> getCopyTo() {
        return copyTo;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "To: '" + this.to + "', From: '" + this.from + "', Content: '" + this.content + "', Subject: '"
                + this.subject + "', copyTo: '" + this.copyTo + "'";
    }

}
