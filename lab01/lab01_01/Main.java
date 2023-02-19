/* Практика #1, часть 1
 *  Создать приложение, которое отображает в окне консоли аргументы командной строки метода main() в обратном порядке.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Source input:");
        for (String arg : args) {
            System.out.printf("%s ", arg);
        }
        System.out.println();
        System.out.println();
        System.out.println("Reversed input:");
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.printf("%s ", args[i]);
        }

        System.out.println();
        System.out.println();
        System.out.println("Reversed input (2 edition):");
        for (String arg : args) {
            StringBuilder revstr = new StringBuilder();
            for (int j = arg.length() - 1; j >= 0; j--) {
                revstr.append(arg.charAt(j));
            }
            System.out.printf("%s ", revstr);
        }
    }
}