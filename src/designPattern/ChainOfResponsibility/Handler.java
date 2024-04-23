package designPattern.ChainOfResponsibility;

/**
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-03-12 21:47
 **/
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}