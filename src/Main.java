import java.util.*;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> elevator = new ArrayDeque<>();
        final int waitDoorsInSeconds = 10;
        final int waitMoveInSeconds = 5;
        int totalSecond = 0;

        while (true) {

            System.out.println("Ожидаю ввода этажа: (для завершения нажмите 0)");
            Scanner scanner = new Scanner(System.in);
            int stage = scanner.nextInt();
            if (stage >= 0 && stage < 26) {
                int last = -1;
                while (elevator.peek() != null) {
                    last = elevator.peekLast();
                    if (last != -1) {
                        totalSecond += Math.abs(stage - last) * waitMoveInSeconds;
                        totalSecond += waitDoorsInSeconds;
                    }
                    break;
                }
                elevator.add(stage);
                if (last == stage) {
                    elevator.removeLast();
                    System.out.println("Лифт уже находится на этом этаже");
                    System.out.println();
                }

                if (stage == 0) {

                    System.out.println("Лифт проехал по следующим этажам:");
                    while (!elevator.isEmpty()) {
                        int s = elevator.poll();
                        System.out.print(s + " этаж" + "->" + " ");
                    }

                    System.out.println("Общее время, затраченное лифтом:" + " " + totalSecond + " секунд");
                    System.out.println();
                    System.out.println("Программа завершена!");
                    break;
                }

            } else {
                System.out.println("Такого этажа в доме нет");
            }
        }
    }
}

