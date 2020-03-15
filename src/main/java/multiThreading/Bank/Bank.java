package multiThreading.Bank;

public class Bank {
    public static void main(String[] args) {
        BankThread bankThread = new BankThread();
        bankThread.start();
    }
}

class BankThread extends Thread {
    @Override
    public void run() {

        СashBox cashBox = new СashBox();
        СashBoxThread cashBoxThread = new СashBoxThread(cashBox);
        cashBoxThread.start();

        Client client = new Client();
        ClientThred clientThred = new ClientThred(client);
        clientThred.start();


        for (int i = 1; i < 5; i++) {
            CashierThred cashierThred = new CashierThred(client, cashBox, i);
            cashierThred.start();
        }
    }
}


class СashBox {
    private volatile int cash = 500;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public synchronized void addMoneyToBank() {
        cash = cash + 50;
    }

    public synchronized void getMoneyFromBank() {
        cash = cash - 50;
    }
}

class СashBoxThread extends Thread {
    private volatile СashBox cashBox;

    public СashBoxThread(СashBox cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            cashBox.addMoneyToBank();
            System.out.println("В банк поступили деньги. Теперь в банке:  " + cashBox.getCash() + " денег");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Client {
    private volatile int clientCount = 10;

    public int getClientCount() {
        return clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public synchronized void addNewClient() {
        clientCount++;
    }

    public synchronized void getOneClient() {
        clientCount--;
    }
}

class ClientThred extends Thread {
    private Client client;

    public ClientThred(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            client.addNewClient();
            System.out.println("Пришел клиент. В банке: " + client.getClientCount() + " клиентов");
            try {
                double time = 500 + Math.random() * 1000;
                Thread.sleep((new Double(time).longValue()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class CashierThred extends Thread {
    private Client clientQueue;
    private СashBox cashBox;
    private int id;

    public CashierThred(Client clientQueue, СashBox cashBox, int id) {
        this.clientQueue = clientQueue;
        this.cashBox = cashBox;
        this.id = id;
    }


    public Client getClientQueue() {
        return clientQueue;
    }

    public void setClientQueue(Client clientQueue) {
        this.clientQueue = clientQueue;
    }

    public СashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(СashBox cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (cashBox.getCash() < 0) {
                    try {
                        this.wait();
                        System.out.println("В банке нету денег");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    int addOrGetMoney = (int) (Math.random() * 2);
                    double time = 2000 + Math.random() * 5000;
                    String mas = "";
                    if (addOrGetMoney == 0) {
                        cashBox.addMoneyToBank();
                        mas = "Клиент кладет деньги...";
                    } else {
                        cashBox.getMoneyFromBank();
                        mas = "Клиент снимает деньги...";
                    }
                    System.out.println("Клиет номер " + clientQueue.getClientCount()
                            + " обрабатывается кассиром номер " + id + ". " + mas);

                    clientQueue.getOneClient();
                    Thread.sleep((new Double(time).longValue()));
                    this.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



