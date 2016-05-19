package com.derekeckenroad;

/**
 * Created by derekeckenroad on 5/18/16.
 */
public interface Connection {

    String getIP();
    String getPort();
    String getProtocol();

    void setIP(String ip);
    void setPort(String port);
    void setProtocol(String protocol);

    String connect();
    String close();
}
