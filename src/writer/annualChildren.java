package writer;

import com.fasterxml.jackson.annotation.JsonProperty;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;

public class annualChildren {
    @JsonProperty("annualChildren")
    private List<children> annualChildren = new ArrayList<>();

    public List<children> getAnnualChildren() {
        return annualChildren;
    }

    @Override
    public String toString() {
        return "annualChildren{" +
                "annualChildren=" + annualChildren +
                '}';
    }
}
