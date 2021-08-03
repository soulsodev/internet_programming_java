package POJO;

public class TableModel {

    public TableModel(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public TableModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String id;
    public String name;
    public String price;

}
