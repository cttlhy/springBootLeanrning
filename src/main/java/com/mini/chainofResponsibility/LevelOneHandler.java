package com.mini.chainofResponsibility;

class LevelOneHandler extends Handler{

    @Override
    protected boolean doHandle(int level) {
        if (level == 1) {
            System.out.println("LevelOneHandler 处理了级别为" + level + "请求");
            return true;
        }
        return false;
    }
}
