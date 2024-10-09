package com.mini.chainofResponsibility;

class LevelTwoHandler extends Handler{

    @Override
    protected boolean doHandle(int level) {
        if (level == 2){
            System.out.println("LevelTwoHandler处理了级别是"+level+"的请求");
            return true;
        }
        return false;
    }
}
