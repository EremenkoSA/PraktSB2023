package Task2;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static Task2.Reflection.mapToProductDto;


public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Pet cat = new Pet("Барсик", Status.AVALABLE,
                List.of(new Photo("Барсик с цветочком",
                                "https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках",
                                "https://placekitten.com/500/605")
                ));

        Animal animalCat = mapToProductDto(cat);
        System.out.println(animalCat);
    }
}
