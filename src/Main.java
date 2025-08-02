public class Main {
    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();

        Task task = businessService::runningBusinessLogic;
        Task loggedTask = new LoggerDecorator(task);

        loggedTask.execute();
    }
}