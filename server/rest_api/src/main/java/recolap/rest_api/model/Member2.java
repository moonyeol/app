package recolap.rest_api.model;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member2 {
        @Getter
        @Setter
        private String product_name;
        private String price;
        private String display;
        private String cpu_name;
        private String resolution;
        private String ram;
        private String storage_size;
        private String weight;
}
