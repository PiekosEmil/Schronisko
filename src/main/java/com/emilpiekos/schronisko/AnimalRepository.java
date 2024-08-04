package com.emilpiekos.schronisko;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AnimalRepository {

    private Set<Animal> animals;

    public AnimalRepository() {
        animals = new HashSet<>();
        animals.add(new Animal("Azor", "Początkowo szpic miniaturowy, ze względu na swój ognisty temperament" +
                "oraz szczekliwość, był wykorzystywany wyłącznie, jako pies stróżujący, z czasem zauważono, że ten miniaturowy" +
                "piesek może być nieocenionym towarzyszem życia codziennego. To właśnie za sprawą swojego charakteru i wyjątkowej" +
                "aparycji zyskał na popularności i trafił prosto do arystokracji. ",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVVXtsOwzDzr5GG79sjgbSag_QcbJ7f6OzGQ&s", Category.DOG));
        animals.add(new Animal("Rudy", "Mój pies ma na imię Rudy i jest kundelkiem. Ma długie,stojące" +
                "uszy, które słyszą nawet najmniejszy szelest. Jego oczy są koloru brązowego i są niezwykle bystre. Zawsze," +
                "gdy wypatrzy kota, to jego źrenice rozszerzają się szeroko. Jego sierść jest dwukolorowa - lekko rudawa na" +
                "pyszczku i brzuszku, brązowa natomiast na plecach i tylnich łapach. Ma różowy nos i długi język z plamką na środku." +
                "Jego pazury są długie i prawie białe. Głośno szczeka, gdy ktoś zapuka do drzwi i potrafi wysoko skakać," +
                "gdy chce czegoś dosięgnąć. Potrafi kilka sztuczek takich jak siad, daj głos, turlaj się czy leżeć." +
                "Pies ma długi, brązowy ogon, którym merda, gdy tylko wracam do domu. Rudy jest rasowym kundelkiem" +
                "sięgającym do kolana, ale za to wielkim sercem, przyjacielem rodziny.",
                "https://img.freepik.com/premium-zdjecie/na-ziemi-siedzi-rudy-puszysty-szczeniak-rasy-akita-inu-kochany-pies_414998-15.jpg", Category.DOG));
        animals.add(new Animal("Fenek", "Foxes are small-to-medium-sized omnivorous mammals belonging" +
                "to several genera of the family Canidae. They have a flattened skull; upright, triangular ears; a pointed," +
                "slightly upturned snout; and a long, bushy tail (\"brush\").",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPLTBCS-seXRMk4eC2VgWipshCDP-11uWS6Q&s", Category.OTHER));
        animals.add(new Animal("Diesel", "A tabby cat, or simply tabby, is any domestic cat (Felis catus)" +
                "with a distinctive M-shaped marking on its forehead, stripes by its eyes and across its cheeks," +
                "along its back, around its legs and tail, and characteristic striped, dotted, lined, flecked, banded," +
                "or swirled patterns on the body: neck, shoulders, sides, flanks, chest, and abdomen. The four known distinct patterns," +
                "each having a sound genetic explanation, are the mackerel, classic or blotched, ticked, and spotted tabby patterns.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/1200px-Cat_November_2010-1a.jpg", Category.CAT));
    }

    public Animal findByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public Set<Animal> findAll() {
        return animals;
    }

    public Set<Animal> filterByCategory(String category) {
        return animals.stream().filter(animal -> animal.getCategory().convertEnumToString().equals(category)).collect(Collectors.toSet());
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }
}
