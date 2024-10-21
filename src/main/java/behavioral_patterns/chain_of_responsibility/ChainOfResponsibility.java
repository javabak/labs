package behavioral_patterns.chain_of_responsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler lowLevelHandler = new LowLevelHandler();
        Handler midLevelHandler = new MidLevelHandler();
        Handler highLevelHandler = new HighLevelHandler();

        // Устанавливаем цепочку обязанностей
        lowLevelHandler.setNextHandler(midLevelHandler);
        midLevelHandler.setNextHandler(highLevelHandler);

        // Отправляем запросы
        System.out.println("Отправка запроса 'LowLevel':");
        lowLevelHandler.handleRequest("LowLevel");

        System.out.println("\nОтправка запроса 'MidLevel':");
        lowLevelHandler.handleRequest("MidLevel");

        System.out.println("\nОтправка запроса 'HighLevel':");
        lowLevelHandler.handleRequest("HighLevel");

        System.out.println("\nОтправка неизвестного запроса:");
        lowLevelHandler.handleRequest("Unknown");
    }
}

abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Абстрактный метод для обработки запроса
    public abstract void handleRequest(String request);
}



class LowLevelHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("LowLevel")) {
            System.out.println("LowLevelHandler обработал запрос: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class MidLevelHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("MidLevel")) {
            System.out.println("MidLevelHandler обработал запрос: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class HighLevelHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("HighLevel")) {
            System.out.println("HighLevelHandler обработал запрос: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
