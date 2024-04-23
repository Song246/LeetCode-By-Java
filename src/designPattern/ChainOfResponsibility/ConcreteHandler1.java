package designPattern.ChainOfResponsibility;

/**
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-03-12 21:47
 **/
public class ConcreteHandler1 extends Handler {
    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type1) {
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}