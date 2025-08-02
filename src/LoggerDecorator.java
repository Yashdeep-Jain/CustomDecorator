class LoggerDecorator implements Task {
    private final Task task;

    public LoggerDecorator(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Starting task execution...");
        task.execute();
        System.out.println("Task execution completed.");
    }
}
