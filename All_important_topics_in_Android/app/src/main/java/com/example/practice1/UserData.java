package com.example.practice1;

public class UserData {
    private DataClass data;
    private SupportClass support;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    public SupportClass getSupport() {
        return support;
    }

    public void setSupport(SupportClass support) {
        this.support = support;
    }

    public static class DataClass {
        private String first_name;
        private String last_name;
        private String id;
        private String email;
        private String avatar;

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getAvatar() {
            return avatar;
        }
    }

    public static class SupportClass {
        private String url;
        private String text;

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }
    }
}
