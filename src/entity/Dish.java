package entity;

public class Dish {

    private Integer  dishid;
    private String dishname;
    private String dishkind;
    private Float price;
    private String content;

    public Dish() {
        // TODO Auto-generated constructor stub
    }

    public Dish(Integer dishid, String dishname,String dishkind,Float price,String content) {
        this.dishid = dishid;
        this.dishname = dishname;
        this.dishkind = dishkind;
        this.price = price;
        this.content = content;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getDishid() {
        return dishid;
    }

    public String getContent() {
        return content;
    }

    public String getDishkind() {
        return dishkind;
    }

    public String getDishname() {
        return dishname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }

    public void setDishkind(String dishkind) {
        this.dishkind = dishkind;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


}