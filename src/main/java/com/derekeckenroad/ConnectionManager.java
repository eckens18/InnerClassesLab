package com.derekeckenroad;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConnectionManager {

    int counter;
    int countLimit;

    public ConnectionManager(){
        countLimit = 10;
    }


    private class ManagedConnection implements Connection{

        String IP;
        String Port;
        String Protocol;
        boolean Status = true;

        public ManagedConnection(String ip,String port, String protocol){
            this.IP = ip;
            this.Port = port;
            this.Protocol = protocol;
        }

        public String getIP(){
            if(Status==false){
                return "error";
            }
            return this.IP;
        }

        public String getPort(){
            if(Status==false){
                return "error";
            }
            return this.Port;
        }

        public String getProtocol(){
            if(Status==false) {
                return "error";
            }
            return this.Protocol;
        }

        public void setIP(String ip){
            this.IP = ip;
        }

        public void setPort(String port){
            this.Port = port;
        }

        public void setProtocol(String protocol){
            this.Protocol = protocol;
        }

        public String connect(){
            return "You are connected";
        }

        public String close(){
            if(Status==false){
                return "error";
            }
            counter--;
            Status = false;
            return "Closed";
        }

    }

    public ManagedConnection getConnection(String ip, String protocol){
        if (counter<countLimit) {
            counter++;
            return new ManagedConnection(ip,"portg",protocol);
        } else {
            return null;
        }
    }

    public ManagedConnection getConnection(String ip,String protocol, String port){
        if (counter<countLimit) {
            counter++;
            return new ManagedConnection(ip, protocol, port);
        } else {
            return null;
        }
    }
}
