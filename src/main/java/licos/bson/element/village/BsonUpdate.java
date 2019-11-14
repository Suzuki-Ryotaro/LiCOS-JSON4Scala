package licos.bson.element.village;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import licos.json.element.village.JsonUpdate;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Entity("updates")
public class BsonUpdate extends BsonElement {

    @Id
    @SuppressWarnings("unused")
    private ObjectId _id;

    @Getter @Setter
    private String $id;

    @Getter @Setter
    private String phase;

    @Getter @Setter
    private int day;

    @SuppressWarnings("unused")
    private BsonUpdate() {
        // Do nothing
    }

    public BsonUpdate(ObjectId _id,
                      String $id,
                      String phase,
                      int day) {
        this._id = _id;
        this.$id = $id;
        this.phase = phase;
        this.day = day;
    }

    @Override
    public JsonUpdate toJson() {
        return new JsonUpdate(
                $id,
                phase,
                day
        );
    }
}
