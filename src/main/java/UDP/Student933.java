package UDP;

import java.io.Serializable;

public class Student933 implements Serializable {
    private static final long serialVersionUID = 20161107;
    private String id;
    private String name;
    private String code;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student933(String id, String name, String code, String email) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.email = email;
    }

    public Student933(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student933{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
