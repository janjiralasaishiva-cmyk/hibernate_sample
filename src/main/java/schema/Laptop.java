package schema;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    private int laptop_id;
    private String brand;
    private String model;
    private int RAM;

    public Laptop() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptop_id=" + laptop_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", RAM=" + RAM +
                '}';
    }
}
