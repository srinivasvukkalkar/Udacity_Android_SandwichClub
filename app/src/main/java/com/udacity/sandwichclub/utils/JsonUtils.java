package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        //create the sandwich item
        Sandwich sandwich = new Sandwich();
        //naming all the strings to put in the item
        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> List_for_ingredients = new ArrayList<>();
        ArrayList<String> List_for_alsoKnownAs = new ArrayList<>();

        //retrieve all strings and arrays

        if (json != null){
            try{
                JSONObject sandwichJson = new JSONObject(json);
                JSONObject ObjectForName = sandwichJson.getJSONObject("name");

                mainName = ObjectForName.getString("mainName");
                placeOfOrigin = sandwichJson.getString("placeOfOrigin");
                description = sandwichJson.getString("description");
                image = sandwichJson.getString("image");
                //take JSONarray and return list for ingredients and alsoKnownAs
                JSONArray alsoKnownAs = ObjectForName.getJSONArray("alsoKnownAs");
                for (int i = 0; i < alsoKnownAs.length(); i++){
                    List_for_alsoKnownAs.add(alsoKnownAs.getString(i));
                }

                JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
                for (int i = 0; i < ingredients.length(); i++){
                    List_for_ingredients.add(ingredients.getString(i));
                }

                //Put each string in the sandwhich item
                sandwich.setMainName(mainName);
                sandwich.setAlsoKnownAs(List_for_alsoKnownAs);
                sandwich.setIngredients(List_for_ingredients);
                sandwich.setImage(image);
                sandwich.setPlaceOfOrigin(placeOfOrigin);
                sandwich.setDescription(description);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        return sandwich;
    }

}
