package designPattern.ChainOfResponsibility;

/**
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-03-12 21:42
 **/
public class demo {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);  // handler2的后继指向handler1，返回最上层发的handler2
        Request request1 = new Request(RequestType.type1, "request1");
        handler2.handleRequest(request1);
        Request request2 = new Request(RequestType.type2, "request2");
        handler2.handleRequest(request2);
    }


}
