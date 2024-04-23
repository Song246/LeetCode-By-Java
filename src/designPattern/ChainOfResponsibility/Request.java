package designPattern.ChainOfResponsibility;

/**
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-03-12 21:48
 **/
public class Request {
    private RequestType type;
    private String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}