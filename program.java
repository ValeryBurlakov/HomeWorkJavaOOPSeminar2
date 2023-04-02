
public class program {
    // private Printerimpl printerimpl; // sem 2
    public static void main(String[] args) {
        // Printerimpl printt = new Printerimpl(); // семинар 2
        // SaveFiles savefiles = new Printerimpl(); // семинар 2
        Person Oleg1 = new Person(1, "Oleg", "Brown", 70, Gender.MALE);
        Person Olga1 = new Person(2, "Olga", "Brown", 70, Gender.FEMALE);
        Person Lyuda1 = new Person(3, "Lyuda", "Brown", 50, Gender.FEMALE);
        Person Vitya1 = new Person(4, "Vitya", "Brown", 50, Gender.MALE);
        Person Vera = new Person(5, "Vera", "Brown", 23, Gender.FEMALE);
        Person Lily = new Person(6, "Lily", "Brown", 3, Gender.FEMALE);
        Person Kate = new Person(7, "Kate", "Brown", 5, Gender.FEMALE);
        Person Lena = new Person(8, "Lena", "Brown", 5, Gender.FEMALE);
        
        // создание родства и других связей

        Oleg1.addSpouse(Olga1);
        Lyuda1.addFather(Oleg1);
        Lyuda1.addMother(Olga1);
        Kate.addFather(Oleg1); // внебрачная дочь

        Vitya1.addSpouse(Lyuda1);
        Vera.addFather(Vitya1);
        Vera.addMother(Lyuda1);

        Lily.addMother(Vera); // сестры
        Lena.addMother(Vera); // сестры
        
        System.out.printf("Дети Олега: " + Oleg1.getChildren() + "\n");
        System.out.println("Родители Веры: " + Vera.getMother() + " and " + Vera.getFather());
        System.out.printf("У Люды есть ребенок:" + Lyuda1.getChildren() + "\n");

        // создание дерева персонов
        FamilyTree tree1 = new FamilyTree();

        // добавление в дерево персонов
        tree1.addPerson(Oleg1);
        tree1.addPerson(Olga1);
        tree1.addPerson(Vitya1);
        tree1.addPerson(Lyuda1);
        tree1.addPerson(Vera);
        tree1.addPerson(Lily);
        tree1.addPerson(Kate);        
        tree1.addPerson(Lena);

        // методы нашего дерева
        tree1.printTree(); // вывод более-менее красиво
        System.out.println("Выше у нас представлено генеалогическое дерево" + "\n");
        // tree1.allTree(); // вывод списком экземпляров дерева
        tree1.saveToFile("newTree.txt"); // сохранение в файл

        // printt.print("linkk"); // семинар 2
        // savefiles.savefile("newfiles"); // созранение в файл 2 sem

        // создание комода
        Commode firstCommode = new Commode(01, "black");
        Commode twoCommode = new Commode(02, "white");

        // создание ящиков комода
        Drawer drawer01 = new Drawer(Drawers.one, firstCommode);
        Drawer drawer02 = new Drawer(Drawers.two, firstCommode);
        Drawer drawer03 = new Drawer(Drawers.three, firstCommode);
        Drawer drawer04 = new Drawer(Drawers.four, firstCommode);

        // метод открывание ящика комода
        OpenDrawer open1 = new OpenDrawer(Oleg1, Drawers.one, firstCommode);
        OpenDrawer open2 = new OpenDrawer(Olga1, Drawers.two, firstCommode);
        OpenDrawer open3 = new OpenDrawer(Vera, Drawers.three, twoCommode);
        OpenDrawer open4 = new OpenDrawer(Kate, Drawers.four, firstCommode);
        OpenDrawer open5 = new OpenDrawer(Vitya1, Drawers.three, twoCommode);
        OpenDrawer open6  = new OpenDrawer(Lena, twoCommode);
        OpenDrawer open7  = new OpenDrawer(Lena, Drawers.all, firstCommode);
        // вывод кто что открыл
        if (open1.getDrawer() == Drawers.one) {
            System.out.printf("%s открыл в комоде цвета %s ящик: %s \n", Oleg1, firstCommode, drawer01);
        }
        if (open2.getDrawer() == Drawers.two) {
            System.out.printf("%s открыла в комоде цвета %s ящик: %s \n", Olga1, firstCommode, drawer02);
        }
        if (open3.getDrawer() == Drawers.three) {
            System.out.printf("%s открыла в комоде цвета %s ящик: %s \n", Vera, twoCommode, drawer01);
        }
        if (open4.getDrawer() == Drawers.four) {
            System.out.printf("%s открыла в комоде цвета %s ящик: %s \n", Kate, firstCommode, drawer04);
        }
        if (open5.getDrawer() == Drawers.three) {
            System.out.printf("%s открыл в комоде цвета %s ящик: %s \n", Vitya1, twoCommode, drawer03);
        }
        if (open5.getDrawer() == Drawers.three) {
            System.out.printf("%s открыл в комоде цвета %s ящик: %s \n", Vitya1, twoCommode, drawer03);
        }

        System.out.println(open6); // можно так укоротить клиентский код
        System.out.println(open7);
    }

}
