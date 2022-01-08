package utils;

import entities.Gift;
import input.ChildUpdateInputData;
import input.ChildrenInputData;
import input.SantaGiftsInputData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Utils {
    private Utils() {
    }

    public static ArrayList<String> convertJSONArray(final JSONArray array) {
        if (array != null) {
            ArrayList<String> finalArray = new ArrayList<>();
            for (Object object : array) {
                finalArray.add((String) object);
            }
            return finalArray;
        } else {
            return null;
        }
    }

    public static ArrayList<SantaGiftsInputData> convertJSONGifts(final JSONArray array) {
        if (array != null) {
            ArrayList<SantaGiftsInputData> finalArray = new ArrayList<>();
            for (Object jsonGift : array) {
                finalArray.add(new SantaGiftsInputData(
                        (String) ((JSONObject) jsonGift).get("productName"),
                        ((Long) ((JSONObject) jsonGift).get("price")).doubleValue(),
                        (String) ((JSONObject) jsonGift).get("category")
                ));
            }
            return finalArray;
        } else {
            return null;
        }
    }

    public static ArrayList<ChildrenInputData> convertJSONNewChildren(final JSONArray array) {
        if (array != null) {
            ArrayList<ChildrenInputData> finalArray = new ArrayList<>();
            for (Object jsonChild : array) {
                finalArray.add(new ChildrenInputData(
                        ((Long) ((JSONObject) jsonChild).get("id")).intValue(),
                        (String) ((JSONObject) jsonChild).get("lastName"),
                        (String) ((JSONObject) jsonChild).get("firstName"),
                        ((Long) ((JSONObject) jsonChild).get("age")).intValue(),
                        (String) ((JSONObject) jsonChild).get("city"),
                        ((Long) ((JSONObject) jsonChild).get("niceScore")).doubleValue(),
                        Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChild)
                                .get("giftsPreferences"))
                ));
            }
            return finalArray;
        } else {
            return null;
        }
    }

    public static ArrayList<ChildUpdateInputData> convertJSONChildrenUpdates(final JSONArray array) {
        if (array != null) {
            ArrayList<ChildUpdateInputData> finalArray = new ArrayList<>();

            for (Object jsonChildUpdate : array) {
                Double niceScore;
                if (((JSONObject) jsonChildUpdate).get("niceScore") != null) {
                    niceScore = ((Long) ((JSONObject) jsonChildUpdate).get("niceScore")).doubleValue();
                } else {
                    niceScore = null;
                }
                finalArray.add(new ChildUpdateInputData(
                        ((Long) ((JSONObject) jsonChildUpdate).get("id")).intValue(),
                        niceScore,
                        Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChildUpdate)
                                .get("giftsPreferences"))
                ));
            }
            return finalArray;
        } else {
            return null;
        }
    }
}
