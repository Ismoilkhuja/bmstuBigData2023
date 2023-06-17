package lab08_01_02;

class LegThread implements Runnable {
    private String legName;

    public LegThread(String legName) {
        this.legName = legName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (legName.equals("LEFT")) {
                System.out.println("LEFT");
            } else if (legName.equals("RIGHT")) {
                System.out.println("RIGHT");
            }

            try {
                Thread.sleep(1000); // Задержка между шагами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class RobotApplication {
    public static void main(String[] args) {
        Thread leftLegThread = new Thread(new LegThread("LEFT"));
        Thread rightLegThread = new Thread(new LegThread("RIGHT"));

        leftLegThread.start();
        rightLegThread.start();
    }
}
