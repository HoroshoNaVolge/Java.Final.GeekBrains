import java.util.*;

public class Operations {

    private Set<Notebook> notebooks;
    private static Scanner scanner;

    public void printList() {
        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }

    public Operations(Set<Notebook> notebooks) {
        scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public int getCriteria() {
        String text = "Введите цифру, соответствующую необходимому критерию: ";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++) {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property) {

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties() {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Марка");
        map.put("RAM", "Объем памяти");
        map.put("opSystem", "Операционная система");
        map.put("model", "модель");
        map.put("price", "цена");

        return map;

    }

    public List<String> propertiesForFilter() {
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("RAM");
        list.add("opSystem");
        list.add("model");
        list.add("price");

        return list;
    }

    public String getOperations() {

        String text = "Выберите операцию: \n " +
                "1. Выбрать по критерию \n " +
                "2. Вывести весь список \n " +
                "3. Сортировать список по возрастанию \n " +
                "4. Завершить \n";

        System.out.println(text);

        String answer = scanner.next();

        return answer;
    }

    public void start() {

        String operation = getOperations();
        if (operation.equals("4")) {
            scanner.close();

        } else if (operation.equals("1")) {

            int criterion = getCriteria();
            filteredList(criterion);

        } else if (operation.equals("2")) {
            printList();
        }

        else if (operation.equalsIgnoreCase("3")) {
            SortSet();
        }
    }

    private void SortSet() {
        System.err.println("Список отсорирован по алфавиту:");

        // Сортировка в алфавитном порядке.
        notebooks.stream()
                .sorted(new NotebookComparator())
                .forEach(p -> System.out.println(p.toString()));
    }

    private void filteredList(int criterion) {
        Set<Notebook> filtedNotebooks = new HashSet<Notebook>();
        for (Notebook notebook : notebooks) {
            switch (criterion) {
                case 1:
                    filtedNotebooks.add(new Notebook(notebook.getName()));
                    break;
                case 2:
                    filtedNotebooks.add(new Notebook(notebook.getName(), notebook.getRAM(), "RAM"));
                    break;

                case 3:
                    filtedNotebooks.add(new Notebook(notebook.getName(), notebook.getOpSystem(), "op"));
                    break;

                case 4:
                    filtedNotebooks.add(new Notebook(notebook.getName(), notebook.getModel(), "model"));
                    break;

                case 5:
                    filtedNotebooks.add(new Notebook(notebook.getName(), notebook.getPrice(), "price"));
                    break;
            }

        }

        for (Notebook nb : filtedNotebooks) {
            System.out.println(nb.filteredToString());
        }
        start();

    }

}

class NotebookComparator implements Comparator<Notebook> {

    public int compare(Notebook a, Notebook b) {

        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
