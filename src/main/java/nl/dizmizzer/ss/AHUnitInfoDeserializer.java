package nl.dizmizzer.ss;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AHUnitInfoDeserializer implements JsonDeserializer<Double> {

    private final Pattern smallerSizePattern = Pattern.compile("([0-9.]+) (?:g|ml)");
    private final Pattern mainSizePattern = Pattern.compile("([0-9.]+) (?:kg|l|stuks|personen|plakjes|rollen|wasbeurten)");
    private final Set<String> singleUnitText = new HashSet<>();
    private final Set<String> unitData;

    public AHUnitInfoDeserializer(Set<String> unitData) {
        this.unitData = unitData;
        singleUnitText.add("tros");
        singleUnitText.add("per stuk");
    }
    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonPrimitive()) return null;
        if (!json.getAsJsonPrimitive().isString()) return json.getAsJsonPrimitive().getAsDouble();
        String s = json.getAsString();

        final Matcher smallSizeMatcher = smallerSizePattern.matcher(s);
        if (smallSizeMatcher.find()) {
            return Double.parseDouble(smallSizeMatcher.group(1)) / 1000;
        }
        final Matcher mainSizeMatcher = mainSizePattern.matcher(s);
        if (mainSizeMatcher.find()) {
            return Double.parseDouble(mainSizeMatcher.group(1));
        }

        unitData.add(s.toLowerCase());
        return null;
    }
}
