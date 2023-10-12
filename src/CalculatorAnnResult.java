import java.util.Scanner;


class CalculatorAnnResult {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение через пробел: ");
        String newCAlk = scan.nextLine();
        System.out.println(calc(newCAlk));
    }
    public static String calc(String newCalk) throws Exception {
        String[] newStr = newCalk.split(" "); //Разделим строку по пробелам
        String res = " ";
        if (newStr.length != 3) {
            System.out.println("Неверный формат выражения!");
        } else {
            try {
                Integer a = Integer.valueOf(newStr[0]);
                Integer b = Integer.valueOf(newStr[2]);
                if (a > 10 || b > 10) {
                    System.out.println("Неверный формат выражения!");
                } else {
                    switch (newStr[1]) {
                        case "+":
                            System.out.println(a + b);
                            break;
                        case "-":
                            System.out.println(a - b);
                            break;
                        case "/":
                            System.out.println(a / b);
                            break;
                        case "*":
                            System.out.println(a * b);
                            break;
                        default:
                            System.out.println("Неверный формат выражения!");
                    }
                }
            } catch (NumberFormatException e) {
                int c = -1;
                int d = -1;
                for (Arabian abc : Arabian.values()) {
                    if ((abc.name().equals(newStr[0]))) {
                        c = abc.getConverter();
                    }
                    if ((abc.name().equals(newStr[2]))) {
                        d = abc.getConverter();
                    }
                }
                if (c > 10 || d > 10) {
                    System.out.println("Неверный формат выражения!");
                }else if (c == -1| d == -1){
                    throw new Exception("Неверный формат выражения!");
                } else {
                    int result = 0;
                    switch (newStr[1]) {
                        case "+":
                            result = c + d;
                            break;
                        case "-":
                            result = c - d;
                            break;
                        case "/":
                            result = c / d;
                            break;
                        case "*":
                            result = c * d;
                            break;
                        default:
                            System.out.println("Неверный формат выражения!");
                    }
                    if (result > 0) {
                        for (Arabian abc : Arabian.values()) {
                            if ((abc.getConverter() == result)) {
                                System.out.println(abc.name());
                            }
                        }
                    }else {
                        throw new Exception("Неверный формат выражения!");
                    }
                }
            }
        }
        return res;
    }
}
