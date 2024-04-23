package designPattern.ChainOfResponsibility;

/**
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-03-12 21:48
 **/
public class ConcreteHandler2 extends Handler{
    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type2) {
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}