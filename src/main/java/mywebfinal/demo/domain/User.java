package mywebfinal.demo.domain;

public class User {
    private int id;

    private String uname;

    private String psw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + uname + '\'' +
                ", psw='" + psw +
                '}';
    }
}
