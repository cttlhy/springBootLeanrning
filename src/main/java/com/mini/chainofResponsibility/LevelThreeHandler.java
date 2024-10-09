package com.mini.chainofResponsibility;

// 具体处理者3
class LevelThreeHandler extends Handler {

    @Override
    protected boolean doHandle(int level) {
        if (level == 3) {
            System.out.println("LevelThreeHandler 处理了级别为 " + level + " 的请求。");
            return true;
        }
        return false;
    }
}
