package Menu;

import Salad.BasicSalad;
import Salad.CreateSalad;

import java.util.Scanner;

/**
 * Під-менюшки для приготування салату, взаємодії з ним і сортування овочів
 */
public class MakeSaladCommand implements MenuItem{

    @Override
    public void execute() {
        BasicSalad newSalad;
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                \t[Оберіть дію]
                1.Почати створювати салат
                2.Відсортувати овочі
                
                -->\t""");

        int in = scanner.nextInt();
        if (in == 1) {
            newSalad = new CreateSalad(scanner).createSalad();

            System.out.print("""
                    \t[Оберіть дію з приготованим салатом]
                    1.З'їсти його
                    2.Вивести повну інформацію про салат
                    3.Знайти овочі в салаті в заданому діапазоні калорійності
                                    
                    -->\t""");
            int i = scanner.nextInt();
            if (i == 1)
                new MessageforCommand().EatingSaladMessage();
            else if (i == 2)
                SaladInfo.saladInfo(newSalad);
            else if (i == 3)
                new FindByCalorie().findByCalorie(scanner, newSalad);
        }
        else if (in == 2)
            new SortingBasedOn().ask(scanner);

    }
}
