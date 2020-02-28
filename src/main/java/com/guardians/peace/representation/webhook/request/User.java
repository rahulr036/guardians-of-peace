package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String lastSeen;

    private String locale;

    private String userVerificationStatus;

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserVerificationStatus() {
        return userVerificationStatus;
    }

    public void setUserVerificationStatus(String userVerificationStatus) {
        this.userVerificationStatus = userVerificationStatus;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class UserBuilder {
        private String lastSeen;
        private String locale;
        private String userVerificationStatus;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withLastSeen(String lastSeen) {
            this.lastSeen = lastSeen;
            return this;
        }

        public UserBuilder withLocale(String locale) {
            this.locale = locale;
            return this;
        }

        public UserBuilder withUserVerificationStatus(String userVerificationStatus) {
            this.userVerificationStatus = userVerificationStatus;
            return this;
        }

        public User build() {
            User user = new User();
            user.setLastSeen(lastSeen);
            user.setLocale(locale);
            user.setUserVerificationStatus(userVerificationStatus);
            return user;
        }
    }
}
