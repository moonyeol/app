package recolap.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String product_name;
    private String price;
    private String display;
    private String cpu_name;
    private String resolution;
    private String ram;
    private String storage_size;
    private String weight;



    public Member(String product_name, String price, String display, String cpu_name, String resolution, String ram, String storage_size, String weight) {
        this.product_name = product_name;
        this.display = display;
        this.cpu_name = cpu_name;
        this.resolution = resolution;
        this.ram = ram;
        this.storage_size = storage_size;
        this.weight = weight;
        this.price = price;
    }
}
