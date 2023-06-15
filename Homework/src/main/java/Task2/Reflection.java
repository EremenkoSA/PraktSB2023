package Task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Reflection {
    static public Animal mapToProductDto(Pet pet){
        Animal animal = new Animal();
        try {
            Class class1 = pet.getClass();
            Field fieldPet =class1.getDeclaredField("name");
            fieldPet.setAccessible(true);

            class1 = animal.getClass();
            Field fieldAnimal = class1.getDeclaredField("title");
            fieldAnimal.setAccessible(true);

            fieldAnimal.set(animal, fieldPet.get(pet));

            class1 = pet.getClass();
            fieldPet =class1.getDeclaredField("status");
            fieldPet.setAccessible(true);
            Status petStatus = (Status) fieldPet.get(pet);

            class1 = animal.getClass();
            if (petStatus == Status.AVALABLE){
                fieldAnimal = class1.getDeclaredField("isAvailable");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, true);
                fieldAnimal = class1.getDeclaredField("isSold");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, false);
            }
            else {
                fieldAnimal = class1.getDeclaredField("isAvailable");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, false);
                fieldAnimal = class1.getDeclaredField("isSold");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, true);
            }

            //Перекидываем List в Map
            Map<String, String> animalPhotoMap= new HashMap<>();
            String key, value;
            class1 = pet.getClass();
            fieldPet = class1.getDeclaredField("photoList");
            fieldPet.setAccessible(true);
            List petPhotoList = (List) fieldPet.get(pet);
            for(Object object: petPhotoList){
                class1 = object.getClass();
                Method method = class1.getMethod("getName");
                key = (String) method.invoke(object);
                method = class1.getMethod("getURL");
                value = (String) method.invoke(object);
                animalPhotoMap.put(key, value);
            }
            class1 = animal.getClass();
            fieldAnimal = class1.getDeclaredField("photoMap");
            fieldAnimal.setAccessible(true);
            fieldAnimal.set(animal, animalPhotoMap);
        } catch (IllegalAccessException |NoSuchFieldException  | InvocationTargetException| NoSuchMethodException e) {
            e.printStackTrace();
        }
        return animal;
        }
}