package writer;

import com.fasterxml.jackson.annotation.JsonProperty;
import interfaces.IChild;

import java.util.List;

public class children {
    @JsonProperty("children")
    private List<IChild> children;

    public children(List<IChild> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "children{" +
                "children=" + children +
                '}';
    }
}
