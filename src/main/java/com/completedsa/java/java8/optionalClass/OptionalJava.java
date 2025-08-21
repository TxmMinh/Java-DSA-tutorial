package com.completedsa.java.java8.optionalClass;

import java.util.Optional;

public class OptionalJava {
    public static void main(String[] args) {
        String str = null;
        Optional<String> optional = Optional.ofNullable(str);

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        String b = optional.orElse("Default value");
        String c = optional.orElseGet(() -> {
            StringBuffer sb = new StringBuffer();
            return sb.toString();
        });
    }

    public String getOutfitType(Girl girl) {
        return Optional.ofNullable(girl)
                .map(Girl::getOutfit)
                .map(Outfit::getType)
                .orElse("Naked");
    }

    public String getOutfitTypeFilter(Girl girl) {
        return Optional.ofNullable(girl)
                .map(Girl::getOutfit)
                .map(Outfit::getType)
                .filter(s -> s.contains("dress"))
                .orElse("Naked");
    }
}

class Outfit{
    public String type;

    public String getType() { return type; }
}

class Girl{
    private Outfit outfit;

    public Outfit getOutfit() { return outfit; }
}
