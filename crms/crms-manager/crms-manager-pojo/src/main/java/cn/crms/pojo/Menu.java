package cn.crms.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 20:01
 */
public class Menu implements Serializable {

    private int id;
    private String text;
    private int pid;
    private String filename;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private MenuAttributes attributes;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public MenuAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MenuAttributes attributes) {
        this.attributes = attributes;
    }

    private List<Menu> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
