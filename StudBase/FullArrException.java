package joop;

public class FullArrException extends Exception {
    private String msg;

    public FullArrException(String msg) {
        super();
        this.msg = msg;
    }
    public FullArrException(){
        super();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
