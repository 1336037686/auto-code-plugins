package com.lgxtvt.modules.app.entity;

/**
 * 操作结果通知
 * @author LGX_TvT
 * @date 2018-09-05 17:52
 */
public class Message {
    private String message;
    private boolean success;

    public Message() {
    }

    public Message(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
