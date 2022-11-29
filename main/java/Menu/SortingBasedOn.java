package Menu;


import Salad.CreateSalad;
import Vegetable.Vegetable;

import java.util.List;
import java.util.Scanner;

/**
 * Сортування овочів для салату на основі одного з параметрів(Калорії, білки, жири, вуглеводи)
 */
public class SortingBasedOn implements MenuItem {

    @Override
    public void execute() {}

    public void ask(Scanner scanner){
        System.out.print("""
                \t[На базі чого будемо сортувати?]
                1.Калорійність
                2.Білки
                3.Жири
                4.Вугляводи
                
                -->\t""");
        int s = scanner.nextInt();
        if (s == 1)
            sortByCallories();
        else if (s == 2)
            sortByProteins();
        else if (s == 3)
            sortByFats();
        else if (s == 4)
            sortByCarbohydrates();
        else{
            System.out.println("Ви ввели неправильне число");
            new Exit().execute();}
    }

    public void sortByCallories(){
        List<Vegetable> list = CreateSalad.vegetables();
        list.sort((x1,x2)-> (int) (x1.getCalories()-x2.getCalories()));
        new MessageforCommand().SortingMessage(1);
        list.forEach(x-> System.out.println(x.veggiePlusCalorie()));
    }

    public void sortByProteins(){
        List<Vegetable> list = CreateSalad.vegetables();
        list.sort((x1,x2)-> (int) (x1.getProteins()-x2.getProteins()));
        new MessageforCommand().SortingMessage(2);
        list.forEach(x-> System.out.println(x.veggiePlusProteins()));
    }
    public void sortByFats(){
        List<Vegetable> list = CreateSalad.vegetables();
        list.sort((x1,x2)-> (int) (x1.getFats()-x2.getFats()));
        new MessageforCommand().SortingMessage(3);
        list.forEach(x-> System.out.println(x.veggiePlusFats()));
    }

    public void sortByCarbohydrates(){
        List<Vegetable> list = CreateSalad.vegetables();
        list.sort((x1,x2)-> (int) (x1.getCarbohydrates()-x2.getCarbohydrates()));
        new MessageforCommand().SortingMessage(4);
        list.forEach(x-> System.out.println(x.veggiePlusCarbo()));
    }
}
