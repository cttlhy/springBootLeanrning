package com.mini.chainofResponsibility;

abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final void handleRequest(int level){
        // 处理请求
        boolean handled = doHandle(level);

        // 如果未处理并且有下一个处理者，传递给下一个处理者
        if (!handled && nextHandler != null){
            nextHandler.handleRequest(level);
        } else if (!handled) {
            System.out.println("没有处理器能够处理请求: " + level);
        }
    }

    protected abstract boolean doHandle(int level);

}