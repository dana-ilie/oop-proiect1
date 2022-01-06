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
                        (Double) ((JSONObject) jsonGift).get("price"),
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
                        (Integer) ((JSONObject) jsonChild).get("id"),
                        (String) ((JSONObject) jsonChild).get("lastName"),
                        (String) ((JSONObject) jsonChild).get("firstName"),
                        (Integer) ((JSONObject) jsonChild).get("age"),
                        (String) ((JSONObject) jsonChild).get("city"),
                        (Double) ((JSONObject) jsonChild).get("niceScore"),
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
                finalArray.add(new ChildUpdateInputData(
                        (Integer) ((JSONObject) jsonChildUpdate).get("id"),
                        (Double) ((JSONObject) jsonChildUpdate).get("niceScore"),
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
