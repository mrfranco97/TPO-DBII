package grupo11.tpo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document("Amenity")

public class Amenity {
    private String name;
    private String description;

    public Amenity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
