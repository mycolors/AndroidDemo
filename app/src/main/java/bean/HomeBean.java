package bean;

public class HomeBean {


    public static final int SINGLE_CLICK = 1;

    private int type;

    private String title;

    public HomeBean(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
